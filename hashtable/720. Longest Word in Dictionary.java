// https://leetcode.com/problems/longest-word-in-dictionary/
class Solution { // 34 ms, 39.5 MB
    public String longestWord(String[] words) {
        Arrays.sort(words);
        
        Set<String> set = new HashSet();
        for (String s : words) {
            set.add(s);
        }
        
        String[] candidates = new String[words.length];
        int p = 0;
        int maxLen = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            String w = words[i];
            
            if (check(set, w)) {
                if (w.length() > maxLen) {
                    maxLen = w.length();
                    p = 0;
                    candidates[p] = w;
                } else if (w.length() == maxLen) {
                    p++;
                    candidates[p] = w;
                }
            }
        }
        
        candidates = Arrays.copyOfRange(candidates, 0, p + 1);
        Arrays.sort(candidates);
        
        return candidates[0];
    }
    
    private boolean check(Set<String> set, String s) {
        char[] array = s.toCharArray();
        String sub = "";
        
        for (char c : array) {
            sub += c;
            if (!set.contains(sub)) {
                return false;
            }
        }
        
        return true;
    }
}

class Solution { // 18ms, 38.5 MB
    public String longestWord(String[] words) {        
        Arrays.sort(words);
        
        Set<String> set = new HashSet();
        String res = "";
        
        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1 ))) {
                set.add(w);
                res = res.length() < w.length() ? w : res;
            }
        }
        
        return res;
    }
}
