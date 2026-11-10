class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i:nums1){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        int res[] = new int[1000];
        int index=0;
        for(int i:nums2){
            if(freq.containsKey(i)){
                res[index++]=i;
                if(freq.get(i)==1){
                    freq.remove(i);
                } else{
                    freq.put(i,freq.get(i)-1);
                }
            }
        }
        return Arrays.copyOf(res,index);
    }
}