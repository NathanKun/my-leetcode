// https://leetcode.com/problems/distribute-candies/
class Solution1 { // 127 ms
    public int distributeCandies(int[] candies) {        
        return Math.min(candies.length / 2, Arrays.stream(candies).boxed().collect(Collectors.toSet()).size());
    }
}

class Solution2 { // 188 ms
    public int distributeCandies(int[] candies) {        
        return Math.min(candies.length / 2, (int) Arrays.stream(candies).distinct().count());
    }
}

class Solution3 { // 20 ms
    public int distributeCandies(int[] candies) {        
        boolean[] set = new boolean[200001];
        int kind = 0;
        int half = candies.length / 2;
        
        for (int i : candies) {
            if (!set[i + 100000]) {
                set[i + 100000] = true;
                kind++;
            }
            
            if (kind >= half) {
                return kind;
            }
        }
        
        return kind;
    }
}
