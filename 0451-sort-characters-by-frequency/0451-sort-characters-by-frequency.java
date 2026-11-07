class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[128];
        for(char ch:s.toCharArray()){
            freq[ch]++;
        }
        List<List<Character>> bucket = new ArrayList<>();
        for(int i=0; i<=s.length(); i++)
            bucket.add(new ArrayList<>());
        /*
        bucket: frequency -> <list of characters>
        */
        for(int i=48; i<128; i++){
            if(freq[i] == 0) continue;
            bucket.get(freq[i]).add((char)i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=bucket.size()-1; i>=1 ; i--){
            for(char ch:bucket.get(i)){
                for(int j=0; j<i; j++){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}