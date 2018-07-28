// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Solution1 { // 52 ms
    public int[] twoSum(int[] numbers, int target) {
        int maxIndex = numbers.length;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                maxIndex = i;
                break;
            }
        }
        
        for (int i = 0; i < maxIndex; i++) {
            for (int j = i + 1; j < maxIndex; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        
        return new int[] { maxIndex, maxIndex + 1 };
    }
}

class Solution2 { // 0 ms
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int sum = numbers[i] + numbers[j];
        
        while (sum != target) {
            if (sum < target) {
                i++;
            } else {
                j--;
            }
            
            sum = numbers[i] + numbers[j];
        }
        
        return new int[] { i + 1, j + 1 };
    }
}
