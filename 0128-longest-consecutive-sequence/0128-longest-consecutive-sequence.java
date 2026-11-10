class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int count=1, res=0;
        for(int i:set){
            if(set.contains(i-1)){
                continue;
            }
            while(set.contains(i+1)){
                i++;
                count++;
            }
            res=Math.max(res,count);
            count=1;
        }
        return res;
    }
}