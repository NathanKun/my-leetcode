// https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int iZero = 0, iTwo = nums.length - 1;
        
        for (int i = 0; i <= iTwo; i++) {
            if (nums[i] == 0 && i != iZero) {
                nums[i--] = nums[iZero];
                nums[iZero++] = 0;
            } else if (nums[i] == 2 && i != iTwo) {
                nums[i--] = nums[iTwo];
                nums[iTwo--] = 2;
            }
        }
    }
}

class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    
    private void quickSort(int[] nums, int s, int e) {
        if (s > e) {
            return;
        }
        
        int pivot = nums[s];
        int i = s, j = e;
        
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            
            nums[i] = nums[j];
            
            while (i < j && nums[i] < pivot) {
                i++;
            }
            
            nums[j] = nums[i];
        }
        
        nums[i] = pivot;
        
        quickSort(nums, s, i - 1);
        quickSort(nums, i + 1, e);
    }
}
