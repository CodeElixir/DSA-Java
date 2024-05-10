class Node { 
	int key; 
	int value; 
	Node prev; 
	Node next; 

	public Node(int key, int value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 

class LRUCache {

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        Node node = this.map.get(key);
        if (this.size == 1) {
            return node.value;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        insertHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (!this.map.containsKey(key)) {
            Node node = new Node(key, value);
            this.map.put(key, node);
            if (size == capacity) {
                Node toRemove = this.tail.prev;
                map.remove(toRemove.key);
                toRemove.prev.next = toRemove.next;
                toRemove.next.prev = toRemove.prev;
                this.size--;
            }
            this.insertHead(node);
            this.size++;
        } else {
            Node node = this.map.get(key);
            node.value = value;
            if (this.size == 1) {
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            insertHead(node);
        }
    }

    private void insertHead(Node node) {
        node.next = this.head.next;
        node.next.prev = node;
        node.prev = this.head;
        this.head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */