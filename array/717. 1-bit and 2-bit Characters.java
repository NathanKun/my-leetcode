// https://leetcode.com/problems/1-bit-and-2-bit-characters
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // xxx0xxxxxxx0
        // xxx00        T
        // xxx010       F
        // xxx0110      T
        // xxx01110     F
        // xxx011110    T
        // xxx0111110   F
        // 1Count % 2 == 0 => T else F
        
        final int len = bits.length;
        int counter = 0;
        
        for (int i = len - 2; i >= 0; i --) {
            if (bits[i] == 1) {
                counter++;
            } else {
                break;
            }
        }
        
        return counter % 2 == 0;
    }
}
