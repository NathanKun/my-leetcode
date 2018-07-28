// https://leetcode.com/problems/degree-of-an-array/description/
class Solution1 { // 59 ms
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        int degree = 0, result = nums.length;
        Map<Integer, Integer> map = new HashMap();
        List<Integer> possibleNumbers = new ArrayList();
        
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();
            if (v > degree) {
            	possibleNumbers.clear();
            	degree = v;
            }
            if (v >= degree) {
                possibleNumbers.add(k);
            }
        }

        for (Integer i : possibleNumbers) {
	        int start = 0, end = nums.length - 1;
	        while (nums[start] != i) {
	            start++;
	        }
	        while (nums[end] != i) {
	            end--;
	        }
	        
	        result = Math.min(end - start + 1, result);
        }
        return result;
    }
}

class Solution2 { // 21ms
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        int degree = 0, result = nums.length;
        List<Integer> possibleNumbers = new ArrayList();
        int maxOfNums = nums[0];
        
        for (int n : nums) {
            if (maxOfNums < n) {
            	maxOfNums = n;
            }
        }
        
        int[] array = new int[maxOfNums + 1];
        
        for (int n : nums) {
        	array[n]++;
        }
        
        for (int i = 0; i <= maxOfNums; i++) {
        	int val = array[i];
            if (val > degree) {
            	possibleNumbers.clear();
                possibleNumbers.add(i);
            	degree = val;
            }
            if (val == degree) {
                possibleNumbers.add(i);
            }
        }

        for (Integer i : possibleNumbers) {
	        int start = 0, end = nums.length - 1;
	        while (nums[start] != i) {
	            start++;
	        }
	        while (nums[end] != i) {
	            end--;
	        }
	        
	        result = Math.min(end - start + 1, result);
        }
        return result;
    }
}

