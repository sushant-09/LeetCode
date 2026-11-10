class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return new ArrayList<>();
        int[] window_freq = new int[26], p_freq=new int[26];
        for(char ch:p.toCharArray()){
            p_freq[ch-'a']++;
        }
        for(int i=0; i<p.length(); i++){
            window_freq[s.charAt(i)-'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if(Arrays.equals(window_freq,p_freq)){
            res.add(0);
        }
        for(int i=p.length(); i<s.length(); i++){
            window_freq[s.charAt(i)-'a']++;
            window_freq[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(window_freq,p_freq)){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}