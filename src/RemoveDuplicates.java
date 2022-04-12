public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr = {1, 1, 2};
        //System.out.println(removeDuplicates(arr));
//        int[] newArray = removeDuplicates(arr);
//        for (int i : newArray) System.out.printf("%2d\t", i);
        System.out.println(removeDuplicates(arr));
    }


    private static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) nums[++j] = nums[i];
        }
        return j + 1;
    }

}
