class Solution {
    public int jump(int[] nums) {
        int maxReach=0, jumps=0, currentJumpReach=0;
        for(int i=0; i<nums.length; i++){
            maxReach = Math.max(maxReach,i+nums[i]);
            if(currentJumpReach == i && i!=nums.length-1){
                jumps++;
                currentJumpReach = maxReach;
            }
        }
        return jumps;
    }
}