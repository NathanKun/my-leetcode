// https://leetcode.com/problems/search-insert-position/
class Solution1 { // 4ms
	public int searchInsert(final int[] nums, final int target) {
		final int len = nums.length;
		if (len == 0) {
			return 0;
		}

		if (target < nums[0]) {
			return 0;
		}
		if (target > nums[len - 1]) {
			return len;
		}

		int left = 0, right = len - 1;
		int i = (right - left) / 2 + left;

		while (nums[left] < target && nums[right] > target) {
			if (nums[i] > target) {
				right = i - 1;
			}
			else if (nums[i] < target) {
				left = i + 1;
			}
			else {
				return i;
			}
			i = (right - left) / 2 + left;
		}

		if (nums[left] == target) {
			return left;
		}

		if (nums[right] == target) {
			return right;
		}

		if (nums[left] > target) {
			return left;
		}

		if (nums[right] < target) {
			return right + 1;
		}

		return 0;
	}
}

class Solution2 // 4ms {
	public int searchInsert(final int[] nums, final int target) {
		final int len = nums.length;
		if (len == 0) {
			return 0;
		}

		if (target <= nums[0]) {
			return 0;
		} else if (target > nums[len - 1]) {
			return len;
		} else if (target == nums[len - 1]) {
			return len - 1;
		}

		int left = 0, right = len;
		int i;

		while (left < right) {
			i = (right + left) / 2;

			if (nums[i] == target) {
				return i;
			}

			if (right - left == 1) {
				return nums[i] > target ? left : right;
			}

			if (nums[i - 1] < target && nums[i] > target) {
				return i;
			}

			if (nums[i] > target) {
				right = i;
			} else {
				left = i;
			}
		}

		return 0;
	}
}
