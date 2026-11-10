class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Character> smap = new HashMap<>(), tmap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char schar = s.charAt(i), tchar = t.charAt(i);
            if(smap.containsKey(schar) && smap.get(schar) != tchar){
                return false;
            }
            if(tmap.containsKey(tchar) && tmap.get(tchar) != schar){
                return false;
            }
            smap.put(schar,tchar);
            tmap.put(tchar,schar);
        }
        return true;
    }
}