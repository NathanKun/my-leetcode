// https://leetcode.com/problems/shortest-completing-word/
class Solution1 { // 50 ms
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> plate = new HashMap();
        String res = null;
        
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 65) {
                plate.put(c, plate.getOrDefault(c, 0) + 1);
            }
        }
        
        for (String w : words) {
            Map<Character, Integer> wordSet = new HashMap();
            
            for (char c : w.toLowerCase().toCharArray()) {
                wordSet.put(c, wordSet.getOrDefault(c, 0) + 1);
            }
            
            boolean ok = true;
            for (char key : plate.keySet()) {
                if (!(wordSet.containsKey(key) && wordSet.get(key) >= plate.get(key))) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                if (res == null) {
                    res = w;
                } else if (res.length() > w.length()) {
                    res = w;
                }
            }
        }
        
        return res;
    }
}

class Solution2 { // 7 ms
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plate = new int[26];
        String res = null;
        
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            int i = c - 'a';
            if (i >= 0 && i <= 25) {
                plate[i]++;
            }
        }
        
        for (String w : words) {
            int[] wordMap = new int[26];
            
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                wordMap[i]++;
            }
            
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (wordMap[i] < plate[i]) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                if (res == null) {
                    res = w;
                } else if (res.length() > w.length()) {
                    res = w;
                }
            }
        }
        
        return res;
    }
}
