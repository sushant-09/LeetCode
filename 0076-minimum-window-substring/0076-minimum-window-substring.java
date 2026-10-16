class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()){
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];
        int required=0;
        for(char ch: t.toCharArray()){
            if(need[ch]==0){
                required++;
            }
            need[ch]++;
        }

        int l=0, r=0, formed=0, start=0, len=Integer.MAX_VALUE;

        while(r<s.length()){
            char right = s.charAt(r);
            window[right]++;
            if(need[right]>0 && window[right]==need[right]){
                formed++;
            }
            while(formed == required){
                if(len>r-l+1){
                    len = r-l+1;
                    start=l;
                }
                char left = s.charAt(l);
                window[left]--;
                if(need[left] > 0 && window[left] < need[left]){
                    formed--;
                }
                l++;
            }
            r++;
        }
        
        return len==Integer.MAX_VALUE? "" : s.substring(start,start+len);

    }
}