// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution1 { // 20ms
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        int i = 0;
        
        while (i < nums.length && nums[i] == copy[i]) {
            i++;
        }
        
        int start = i;
        i = nums.length - 1;
        
        while (i > start && nums[i] == copy[i]) {
            i--;
        }
        
        return i - start + 1;
    }
}

class Solution2 { // 13ms
    public int findUnsortedSubarray(int[] nums) {
        final int len = nums.length;
        if (len == 1) {
            return 0;
        }
        
        int i = 1;
        while (i < len && nums[i] >= nums[i - 1]) {
            i++;
        }
        
        int iBefore = i - 1;
        int min = nums[iBefore];
        
        while (i < len) {
            if (nums[i] < min) {
                iBefore -= 1;
                if (iBefore < 0) {
                    break;
                }
                min = nums[iBefore];
            } else {
                i++;
            }
        }
        
        i = len - 1;
        while (i > 0 && nums[i - 1] <= nums[i]) {
            i--;
        }
        
        int iAfter = i + 1 < len ? i + 1 : i;
        int max = nums[iAfter];
        
        while (i >= 0) {
            if (nums[i] > max) {
                iAfter += 1;
                if (iAfter >= len) {
                    break;
                }
                max = nums[iAfter];
            } else {
                i--;
            }
        }
        
        return iAfter > iBefore ? iAfter - iBefore - 1 : 0;
    }
}
