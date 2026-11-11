class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l=0, r=0, res=0;
        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res,r-l+1);
            set.add(s.charAt(r));
            r++;
        }
        return res;
    }
}