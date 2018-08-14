// https://leetcode.com/problems/max-chunks-to-make-sorted/
class Solution {
	public int maxChunksToSorted(final int[] arr) {
		if (arr.length == 1) {
			return 1;
		}

        int count = 1;
        int left = 0;
        while (left < arr.length) {
            int[] sub = Arrays.copyOfRange(arr, left, arr.length + 1);
            int min = Integer.MAX_VALUE;
            int oldLeft = left;
            for (int i = oldLeft; i < arr.length; i++) {
                final int val = arr[i];
                if (val < min) {
                    min = val;
                    left = i + 1;
                }
            }
            
            boolean checkAgain;
            do {
                checkAgain = false;
                int leftMax = Integer.MIN_VALUE;
                for (int i = oldLeft; i < left; i++) {
                    final int val = arr[i];
                    if (val > leftMax) {
                        leftMax = val;
                    }
                }

                oldLeft = left;
                for (int i = oldLeft; i < arr.length; i++) {
                    final int val = arr[i];
                    if (val < leftMax) {
                        left = i + 1;
                        checkAgain = true;
                    }
                }
                
            } while (checkAgain && left < arr.length);
            
            if (left < arr.length) {
                count++;
            }
        }

		return count;
	}
}
