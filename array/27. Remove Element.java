class Solution1 // 5ms
{
	public int removeElement(final int[] nums, final int val)
	{
		final int len = nums.length;
		if (len == 0) {
			return 0;
		}

		int count = 0;
		int i = 0;

		while (i + count < len) {
			if (nums[i] == val) {
				count++;
				for (int j = i; j < len - count; j++) {
					nums[j] = nums[j + 1];
				}
			} else {
                i++;
            }
		}

		return len - count;
	}
}

class Solution2 // 5ms
{
	public int removeElement(final int[] nums, final int val)
	{
		final int len = nums.length;
		if (len == 0) {
			return 0;
		}
        if (len == 1) {
            return nums[0] == val ? 0 : 1;
        }

		int left = 0, right = len - 1;

		while (left < right) {
			if (nums[left] == val) {
				nums[left] = nums[right--];
			}
			else {
				left++;
			}
		}

		return nums[left] == val ? right : right + 1;
	}
}
