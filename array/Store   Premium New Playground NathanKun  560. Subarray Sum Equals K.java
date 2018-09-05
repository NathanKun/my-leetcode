// https://leetcode.com/problems/subarray-sum-equals-k/
class Solution1 { // time limit exceeded
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sums = new int[encode(len, len) + 1];
        int res = 0;
        
        for (int s = len - 1; s >= 0; s--) {
            for (int e = s; e < len; e++) {
                sums[encode(s, e)] = Integer.MIN_VALUE;
            }
        }
        
        for (int s = len - 1; s >= 0; s--) { // 9 8 ... 1 0
            for (int e = s; e < len; e++) { // 9,9 8,8 8,9 7,7 7,8 7,9 ... 1,1 1,2 ... 1,8 1,9 ... 0,0 0,1 ... 0,8 0,9
                if (s == e) {
                  sums[encode(s, e)] = nums[s];
                } else if (e - s == 1) {
                    sums[encode(s, e)] = nums[s] + nums[e];
                } else {
                    sums[encode(s, e)] = sums[encode(s + 1, e)] + nums[s];
                }
            }
        }
        
        for (int s = len - 1; s >= 0; s--) {
            for (int e = s; e < len; e++) {
                if (sums[encode(s, e)] == k) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private int encode(int s, int e) {
        return (1 + e) * e / 2 + s;
    }
}

class Solution2 { // 21 ms, O(n)
    /* If the cumulative sum(repreesnted by sum[i]sum[i] for sum upto i^{th}i th index) 
     * upto two indices is the same, the sum of the elements lying in between those indices is zero. 
     * Extending the same thought further, if the cumulative sum upto two indices, 
     * say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, 
     * the sum of elements lying between indices ii and jj is kk.
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // map<sum_cumulative, encounted_times>
        Map<Integer, Integer> sumCount = new HashMap();
        int sum = 0;
        int res = 0;
        
        sumCount.put(0, 1);
        
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            
            if (sumCount.containsKey(sum - k)) {
                res += sumCount.get(sum - k);
            }
            
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}
