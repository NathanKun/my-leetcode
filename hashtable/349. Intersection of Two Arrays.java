// https://leetcode.com/problems/intersection-of-two-arrays/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        
        for (int i : nums1) {
            set.add(i);
        }
        
        List<Integer> resList = new ArrayList();
        
        for (int i : nums2) {
            if (set.contains(i)) {
                resList.add(i);
                set.remove(i);
            }
        }
        
        int[] res = new int[resList.size()];
        
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        
        return res;
    }
}
