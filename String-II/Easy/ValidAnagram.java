class Solution {
    public boolean isAnagram(String s, String t) {
        //If not same length not anagram
        if(s.length() != t.length()) return false;
        //maintain a frequency array
        int[] freq = new int[26];
        //increment freq for first string
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        //decrement count for 2nd
        for(char ch:t.toCharArray()){
            freq[ch-'a']--;
            //if it reaches -1 or lower return false
            if(freq[ch-'a']<0) return false;
        }
        return true;
    }
}
