class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        int maxFreq=0;
        for(char ch:s.toCharArray()){
            freq[ch]++;
            maxFreq = Math.max(maxFreq,freq[ch]);
        }
        List<List<Character>> bucket = new ArrayList<>();
        for(int i=0; i<=maxFreq; i++){
            bucket.add(new ArrayList<>());
        }
        for(int i=0; i<128; i++){
            if(freq[i]!=0){
                bucket.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=maxFreq; i>0; i--){
            for(char ch:bucket.get(i)){
                for(int j=0; j<i; j++){
                    sb.append(ch);
                }
            }
        }
        return String.valueOf(sb);
    }
}