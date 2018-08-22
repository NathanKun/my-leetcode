// https://leetcode.com/problems/valid-triangle-number/
class Solution1 { // 201 ms
    public int triangleNumber(int[] nums) {
        final int len = nums.length;
        //Map<Integer, Integer> map = new HashMap();
        int count = 0;
        
        Arrays.sort(nums);
        
        for (int iA = 0; iA < len - 2; iA++) {
            for (int iB = iA + 1; iB < len - 1; iB++) {
                for (int iC = iB + 1; iC < len; iC++) {
                    if (isTriangle(nums[iA], nums[iB], nums[iC])) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean isTriangle(int a, int b, int c) {
        return  (a + b) > c; // because a <= b <= c
    }
}

class Solution { // 29 ms
    public int triangleNumber(int[] nums) {
        final int len = nums.length;
        //Map<Integer, Integer> map = new HashMap();
        int count = 0;
        
        Arrays.sort(nums);
        
        for (int iA = 0; iA < len - 2; iA++) {
            if (nums[iA] == 0) continue;
            
            int left = iA + 2;
            for (int iB = iA + 1; iB < len - 1; iB++) {
                left = binarySearch(nums, left, len - 1, nums[iA] + nums[iB]);
                count += left - iB - 1;
            }
        }
        
        return count;
    }
    
    private boolean isTriangle(int a, int b, int c) {
        return  (a + b) > c; // because a <= b <= c
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right && right < nums.length) {
            int mid = (left + right) / 2;
            
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}

class Solution { // 20 ms
    public int triangleNumber(int[] nums) {
        final int len = nums.length;
        //Map<Integer, Integer> map = new HashMap();
        int count = 0;
        
        Arrays.sort(nums);
        
        for (int i = 2; i < len; i++) {
            int left = 0, right = i - 1;
            
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return count;
    }
}
