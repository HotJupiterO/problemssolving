package leetcode.com.array;

import java.util.Arrays;

public class KthLargest {
    private final int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        Arrays.sort(this.nums);
    }

    public int[] getNums() {
        return nums;
    }

    public int add(int val) {
        int[] newArray = new int[this.nums.length + 1];
        boolean found = false;
        for (int i = 0, j = 0; i < nums.length; i++, j++) {
            if (i == nums.length - 1) newArray[i + 1] = val;
            if (!found && val <= nums[i]) {
                newArray[j++] = val;
                found = true;
            }
            newArray[j] = nums[i];
        }
        nums = newArray;
        return nums[nums.length - k];
    }
}

class Main {
    public static void main(String[] args) {
        int a = 1000;
        int not_a = ~a + 1;
        System.out.printf("My number is %d. Negative is %d.\n", a, not_a);
        int i = 1;
        System.out.printf("%d >> %d = %d = %s\n", a, i, a >> i, Integer.toBinaryString(a >> i | 0b000000001));
        System.out.printf("%d << %d = %d = %s\n", a, i, a << i, Integer.toBinaryString(a << i));
        System.out.println(a + " = " + Integer.toBinaryString(a));

        int[] arr = {4, 5, 8, 2}; // [2, 4, 5, 8]
        KthLargest k = new KthLargest(1, arr);
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
        System.out.println(Arrays.toString(k.getNums()));
    }
}
