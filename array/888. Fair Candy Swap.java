// https://leetcode.com/problems/fair-candy-swap/
class Solution1 { // 39 ms
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0, bSum = 0;
        Set<Integer> aSet = new HashSet(), bSet = new HashSet();
        
        for (int n : A) {
            aSum += n;
            aSet.add(n);
        }
        for (int n : B) {
            bSum += n;
            bSet.add(n);
        }
        
        /*
            aSum - x + y = bSum + x - y
            2x + (bSum - aSum) = 2y
            y = (bSum - aSum) / 2 + x
        */
        int aRes = 1, bRes = (bSum - aSum) / 2 + 1;
        
        
        while (!aSet.contains(aRes) || !bSet.contains(bRes)) {
            aRes++;
            bRes++;
        }
        
        return new int[] { aRes, bRes };
    }
}

class Solution2 { // 33 ms
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0, bSum = 0;
        Set<Integer> bSet = new HashSet();
        
        for (int n : A) {
            aSum += n;
        }
        for (int n : B) {
            bSum += n;
            bSet.add(n);
        }
        
        /*
            aSum - x + y = bSum + x - y
            2x + (bSum - aSum) = 2y
            y = (bSum - aSum) / 2 + x
        */
        int diff =  (bSum - aSum) / 2;
        
        
        for (int aRes : A) {
            int bRes = diff + aRes;
            if (bSet.contains(bRes)) {
                return new int[] { aRes, bRes };
            }
        }
        
        return new int[] { -1, -1 };
    }
}
