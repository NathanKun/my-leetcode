// https://leetcode.com/problems/verifying-an-alien-dictionary/
class Solution { // 15 ms
    public boolean isAlienSorted(String[] words, String order) {
        final int[] map = new int[26];
        
        int count = 0;
        for (char c : order.toCharArray()) {
            map[c - 97] = count;
            count++;
        }
        
        Comparator<String> comparator = new Comparator<String>() {
            
            public int compare(String aStr, String bStr) {
                char[] a = aStr.toCharArray();
                char[] b = bStr.toCharArray();

                boolean aLonger = false;
                
                if (a.length > b.length) {
                    aLonger = true;
                }

                for (int i = 0; i < a.length; i++) {
                    int aVal = map[a[i] - 97];
                    int bVal = map[b[i] - 97];
                    if (aVal == bVal) {
                        continue;
                    } else {
                        return aVal > bVal ? 1 : -1;
                    }
                }
                
                if (a.length == b.length) {
                    return 0;
                }
                
                return aLonger ? 1 : -1;
            }
        };
        
        String[] sorted = words.clone();
        Arrays.sort(words, comparator);
        
        for (int i = 0; i < words.length; i++) {
            if (!sorted[i].equals(words[i])) {
                return false;
            }
        }
        
        return true;
    }
}

class Solution2 { // 8 ms
    final int[] map = new int[26];
    
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        
        int count = 0;
        for (char c : order.toCharArray()) {
            map[c - 97] = count;
            count++;
        }
        
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
           
        return true;
    }
    
    private int compare(String aStr, String bStr) {
        char[] a = aStr.toCharArray();
        char[] b = bStr.toCharArray();

        boolean aLonger = false;

        if (a.length > b.length) {
            aLonger = true;
        }

        for (int i = 0; i < (aLonger ? b.length : a.length); i++) {
            int aVal = map[a[i] - 97];
            int bVal = map[b[i] - 97];
            if (aVal == bVal) {
                continue;
            } else {
                return aVal > bVal ? 1 : -1;
            }
        }

        if (a.length == b.length) {
            return 0;
        }

        return aLonger ? 1 : -1;
    }
}
