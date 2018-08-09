// https://leetcode.com/problems/third-maximum-number/
class Solution1 { // 6ms
    public int thirdMax(int[] nums) {
        int max1 = nums[0], max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        boolean hasMax3 = false, hasMax2 = false;
        
        Set<Integer> set = new HashSet();
        for (int n : nums) {
            set.add(n);
        }
      
        Iterator<Integer> iter = set.iterator();
        max1 = iter.next();
        
		while (iter.hasNext()) {
			final int n = iter.next();
            if (n > max1) {
                if (hasMax2) {
                    hasMax3 = true;
                }
                hasMax2 = true;
                
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if ((n > max2 && n < max1) || (max2 == Integer.MIN_VALUE && n == Integer.MIN_VALUE)) {
                if (hasMax2) {
                    hasMax3 = true;
                }
                hasMax2 = true;
                
                max3 = max2;
                max2 = n;
            } else if (n >= max3 && n < max2) {
                max3 = n;
                hasMax3 = true;
            }
        }
        
        if (hasMax3) {
            return max3;
        } else {
            return max1;
        }
    }
}

Solution2 : use long with init value = Integer.MIN_VALUE - 1
Solution3 : use Integer with init value = null
