class Solution {
    public int arrayPairSum(int[] nums) {
        // sort
        Arrays.sort(nums);
        
        // sum
        int sum = 0;
        for(int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }    
        
        return sum;
    }
}
