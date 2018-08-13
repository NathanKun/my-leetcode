// https://leetcode.com/problems/array-nesting/
class Solution1 { // 27 ms
    public int arrayNesting(int[] nums) {
        final int len = nums.length;
        
        if (len == 0 || len == 1) {
            return len;
        }
        
        int[] array = new int[len];
        
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (array[val] == 0) {
                List<Integer> list = new ArrayList();
                list.add(val);
                
                int next = nums[val];
                while (next != val) {
                    list.add(next);
                    next = nums[next];
                }
                
                int size = list.size();
                for (int n : list) {
                    array[n] = size;
                }
            }
        }
        
        int max = 0;
        for (int s : array) {
            if (s > max) {
                max = s;
            }
        }
        
        return max;
    }
}

class Solution2 { // 24 ms
    public int arrayNesting(int[] nums) {
        final int len = nums.length;
        
        if (len == 0 || len == 1) {
            return len;
        }
        
        int[] array = new int[len];
        
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (array[val] == 0) {
                int[] S = new int[len];
                int iS = 0;
                S[iS] = val;
                iS++;
                
                int next = nums[val];
                while (next != val) {
                    S[iS] = next;
                    iS++;
                    next = nums[next];
                }
                
                for (int j = 0; j < iS; j++) {
                    array[S[j]] = iS;
                }
            }
        }
        
        int max = 0;
        for (int s : array) {
            if (s > max) {
                max = s;
            }
        }
        
        return max;
    }
}

class Solution3 { // 21ms
    public int arrayNesting(int[] nums) {
        final int len = nums.length;
        
        if (len == 0 || len == 1) {
            return len;
        }
        
        boolean[] array = new boolean[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (!array[val]) {
                int subarrayLen = 1;
                array[val] = true;
                
                int next = nums[val];
                while (next != val) {
                    array[next] = true;
                    subarrayLen++;
                    next = nums[next];
                }
                
                if (max < subarrayLen) {
                    max = subarrayLen;
                }
            }
        }
        
        return max;
    }
}
