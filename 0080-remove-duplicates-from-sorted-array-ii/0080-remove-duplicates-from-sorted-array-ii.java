class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int l=2, r=2;
        while(r<nums.length){
            if(nums[r]!=nums[l-2]){
                nums[l]=nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}