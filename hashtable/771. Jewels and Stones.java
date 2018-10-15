// https://leetcode.com/problems/jewels-and-stones/
class Solution { // 15ms
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet();
        int res = 0;
        
        for (Character c : J.toCharArray()) {
            set.add(c);
        }
        
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                res++;
            }
        }
        
        return res;
    }
}

class Solution2 { // 10ms
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        char[] jArray = J.toCharArray();
        char[] sArray = S.toCharArray();
        
        for (char j : jArray) {
            for (char s : sArray) {
                if (j == s) {
                    res++;
                }
            }
        }
        
        return res;
    }
}
