// https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution { // 48 ms
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> res = new ArrayList();
        
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count == 0) {
                continue;
            } else if (count == 1) {
                map.remove(n);
                res.add(n);
            } else {
                map.put(n, count - 1);
                res.add(n);
            }
        }
        
        return res.stream().mapToInt(n->n).toArray();
    }
}



class Solution2 { // 1 ms
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] res = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[k++] = nums1[i++];
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return Arrays.copyOfRange(res, 0, k);
    }
}
