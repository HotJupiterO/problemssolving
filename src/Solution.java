class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int k = 0;

        while (nums.length > i) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
            i++;
        }
        return k + 1;
    }
}