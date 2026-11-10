class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] s_array = new int[26], t_array = new int[26];
        for(int i=0; i<s.length(); i++){
            s_array[s.charAt(i)-'a']++;
            t_array[t.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(s_array[i]!=t_array[i]){
                return false;
            }
        }
        return true;
    }
}