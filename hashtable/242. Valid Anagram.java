// https://leetcode.com/problems/valid-anagram/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] sMap = new int[26];
        
        for (char c : s.toCharArray()) {
            sMap[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            sMap[c - 'a']--;
        }
        
        for (int i : sMap) {
            if (i != 0) {
                return false;
            }
        }
        
        return true;
    }
}
