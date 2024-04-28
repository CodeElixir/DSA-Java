class Solution {
    public int maxLength(List<String> arr) {
        int[] selected = new int[26];
		return stringConcatenationHelper(0, arr, selected, 0);
    }

    private int stringConcatenationHelper(int pos, List<String> arr, int[] selected, int len) {
		if (pos == arr.size()) {
			return len;
		}

		String str = arr.get(pos);
		if (checkUnique(str, selected) == false) {
			return stringConcatenationHelper(pos + 1, arr, selected, len);
		}
		
		for (int i = 0; i < str.length(); i++) {
			selected[str.charAt(i) - 'a'] = 1;
		}

		len += str.length();

		int len1 = stringConcatenationHelper(pos + 1, arr, selected, len);

		for (int i = 0; i < str.length(); i++) {
			selected[str.charAt(i) - 'a'] = 0;
		}

		len -= str.length();

		int len2 = stringConcatenationHelper(pos + 1, arr, selected, len);
		
		return Math.max(len1, len2);
		
	}

	private boolean checkUnique(String str, int[] selected) {
		int[] selfCheck = new int[26];
		for (int i = 0; i < str.length(); i++) {
			if (selfCheck[str.charAt(i) - 'a'] == 1) {
				return false;
			}
			selfCheck[str.charAt(i) - 'a'] = 1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (selected[str.charAt(i) - 'a'] == 1) {
				return false;
			}
		}

		return true;
 	}
}