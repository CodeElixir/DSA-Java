class LFUCache {
    private Map<Integer, List<Node>> freqMap;
    private Map<Integer, Node> nodeMap;
    private int size;
    private int capacity;
    private int leastFrequency;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        int freq;
        
        Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    };


    public LFUCache(int capacity) {
        this.freqMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.leastFrequency = 1;
    }
    
    private void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void addHead(Node node, int frequency) {
        Node head = null;
        if (this.freqMap.containsKey(frequency)) {
            head = this.freqMap.get(frequency).get(0);
        } else {
            head = this.initDummyNodes(frequency);
        }
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private Node initDummyNodes(int frequency) {
        Node head = new Node(-1, -1, frequency);
        Node tail = new Node(-1, -1, frequency);
        head.next = tail;
        tail.prev = head;
        List<Node> list = new ArrayList<>(2);
        list.add(head);
        list.add(tail);
        this.freqMap.put(frequency, list);
        return head;
    }

    private void increaseFrequencyAndUpdate(Node node) {
        this.deleteNode(node);
        if (this.leastFrequency == node.freq && this.isEmptyNodeList(node.freq)) {
            this.leastFrequency++;
        }
        node.freq = node.freq + 1;
        this.addHead(node, node.freq);
    }

    private boolean isEmptyNodeList(int frequency) {
        List<Node> list = this.freqMap.get(frequency);
        if (list == null) {
            return true;
        }
        Node head = list.get(0);
        Node tail = list.get(1);
        return head.next == tail && tail.prev == head;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        Node node = this.nodeMap.get(key);
        this.increaseFrequencyAndUpdate(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (this.nodeMap.containsKey(key)) {
            Node node = this.nodeMap.get(key);
            node.value = value;
            this.increaseFrequencyAndUpdate(node);
        } else {
            Node node = new Node(key, value, 1);
            this.nodeMap.put(key, node);
            if (this.size == this.capacity) {
                Node tail = this.freqMap.get(this.leastFrequency).get(1);
                Node delete = tail.prev;
                this.deleteNode(delete);
                this.nodeMap.remove(delete.key);
                this.addHead(node, 1);
            } else {
                this.addHead(node, 1);
                this.size++;
            }
            this.leastFrequency = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */