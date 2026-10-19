class Solution {
    private void reverseArray(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k %= n;
        reverseArray(nums,0,n-k-1);
        reverseArray(nums,n-k,n-1);
        reverseArray(nums,0,n-1);
    }
}