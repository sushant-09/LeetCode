class Solution {
    public void sortColors(int[] nums) {
        int l=0, r=nums.length-1, mid=0;
        while(mid<=r){
            if(nums[mid]==1){
                mid++;
            } else if(nums[mid]==0){
                int temp = nums[l];
                nums[l]=nums[mid];
                nums[mid]=temp;
                mid++;
                l++;
            } else{
                int temp = nums[r];
                nums[r]=nums[mid];
                nums[mid]=temp;
                r--;
            }
        }
    }
}

/*
2,0,2,1,1,0
l         r
m
0,0,2,1,1,2
    l      r
    m




*/