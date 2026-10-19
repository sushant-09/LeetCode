class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int freq=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=majorityElement){
                freq--;
                if(freq==0){
                    majorityElement = nums[i];
                    freq=1;
                }
            }
            else{
                freq++;
            }
        }
        return majorityElement;
    }
}