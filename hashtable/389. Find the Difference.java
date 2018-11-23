// https://leetcode.com/problems/find-the-difference/
class Solution {
    public char findTheDifference(String s, String t) {
        int[] sMap = new int[26];
        
        for (char c : s.toCharArray()) {
            sMap[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            sMap[c - 'a']--;
            
            if (sMap[c - 'a'] == -1) {
                return c;
            }
        }
        
        return '!';
    }
}
