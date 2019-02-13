// https://leetcode.com/problems/isomorphic-strings/
class Solution { // 2 ms, 35.9 MB
    public boolean isIsomorphic(String s, String t) {
        int[] sP = getPattern(s);
        int[] tP = getPattern(t);
        
        return Arrays.equals(sP, tP);
    }
    
    private int[] getPattern(String s) {
        int[] pattern = new int[s.length()];
        int[] set = new int[128];
        int count = 0;
        int i = 0;
        
        for (char c : s.toCharArray()) {
            if (set[c] == 0) {
                count++;
                set[c] = count;
            }
            
            pattern[i] = set[c];
            i++;
        }
        
        return pattern;
    }
}
