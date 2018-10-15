// https://leetcode.com/problems/jewels-and-stones/
class Solution {
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
