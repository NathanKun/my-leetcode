// https://leetcode.com/problems/find-the-duplicate-number/
class Solution1 { // 4 ms
    public int findDuplicate(int[] nums) {
        // increase O(nlogn) time complexity and no space complexity because Arrays.sort sort in-place
        Arrays.sort(nums);
        
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                return last;
            }
            last = nums[i];
        }
        
        return -1;
    }
}

class Solution2 { // 0 ms
    
    // index                               0    1    2    3    4    5    6    7    8    9
    // value                               1    2    3    6    8    7    9    6    5    4
    // 
    // slow    by one step                 1    2    3    6    9    4    8    5    7    6    9    4    8    5    7
    // fast    by two step                 1    3    9    8    7    9    8    ...  intersection found, cycle exists
    // 
    // slow    continue by one step        8    5    7    6    9    4    8    5    7    6
    // fast    start from 0 by one step    1    2    3    6    ...  duplicate number found
    
    public int findDuplicate(int[] nums) {
        // index from 0 to n, value from 1 to n
        // so the array contains cycle
        // and the entry of the cycle is the duplicate number
        
        int onestep = nums[0];
        int twostep = nums[0];
        
        // find the intersection point
        do {
            onestep = nums[onestep];
            twostep = nums[nums[twostep]];
        } while (onestep != twostep);
        
        // onestep keeps going, twostep restarts from head and goes by one step
        twostep = nums[0];
        while (onestep != twostep) {
            onestep = nums[onestep];
            twostep = nums[twostep];
        }
        
        return onestep;
    }
}
