// https://leetcode.com/problems/longest-palindrome/
class Solution1 { // 23 ms
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int res = 0;
        boolean plusOne = false;
        for (int n : map.values()) {
            if (n % 2 == 0) {
                res += n;
            } else {
                res += n - 1;
                plusOne = true;
            }
        }
        
        return res + (plusOne ? 1 : 0);
    }
}

class Solution2 {
    private int getCharIndex(char c) { // 8ms
        if (c - 'A' < 26) {
            return c - 'A';
        }
        return c - 'a' + 26;
    }
    public int longestPalindrome(String s) {
        int[] map = new int[52];
        
        for (char c : s.toCharArray()) {
            map[getCharIndex(c)]++;
        }
        
        int res = 0;
        boolean plusOne = false;
        for (int n : map) {
            if (n % 2 == 0) {
                res += n;
            } else {
                res += n - 1;
                plusOne = true;
            }
        }
        
        return res + (plusOne ? 1 : 0);
    }
}
