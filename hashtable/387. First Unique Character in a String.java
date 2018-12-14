// https://leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        
        List<Character> list = new ArrayList();
        
        for (int i = 0; i < 26; i++) {
            if (map[i] == 1) {
                list.add((char) (i + 'a'));
            }
        }
        
        if (list.size() == 0) {
            return -1;
        } 
        
        int minPos = s.length();
        for (char c : list) {
            int pos = s.indexOf(c);
            if (pos < minPos) {
                minPos = pos;
            }
        }
        
        return minPos;
    }
}
