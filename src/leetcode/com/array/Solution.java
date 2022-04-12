package leetcode.com.array;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Solution {
    public static void main(String[] args) {
        //int[] arr = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        int[] test = {3, 2, 4}; //
        int n = 9;
        String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        String[][] board2 = {
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"6", ".", "9", ".", ".", "8", ".", ".", "."},
                {".", ".", ".", "4", ".", "6", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "1", "."},
                {".", ".", ".", ".", "2", ".", ".", "3", "."},
                {".", "4", ".", ".", ".", ".", ".", ".", "4"},
                {"5", ".", ".", "6", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", "7", ".", "6", ".", "."}
        };

        char[][] arr = strToCharArrConverter(board2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(" %c ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println(isValidSudoku(arr));
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(" %d,%d ", i, j);
            }
            System.out.println();
            System.out.println();
        }*/

    }

    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Array @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * */

    /*-----------------------------UTILITY---------------------------------------------*/
    private static char[][] strToCharArrConverter(String[][] board) {
        int n = board.length;
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i][j].charAt(0);
            }
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int t : arr) System.out.print(t + " ");
        System.out.println();
    }

    private static <T> void printArray(T[] arr) {
        for (T t : arr) System.out.print(t.toString() + " ");
        System.out.println();
    }

    private static <T> void printArray(T[][] arr) {
        for (T[] ar : arr) {
            for (T t : ar) {
                System.out.print(t.toString());
            }
            System.out.println();
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swapInRange(int[] nums, int from, int to) {
        for (int i = from; i < to; i++) swap(nums, i, i + 1);
    }
    /*-----------------------------UTILITY---------------------------------------------*/


    /*-----------------------------MAXIMUM PROFIT---------------------------------------------*/
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
    /*-----------------------------MAXIMUM PROFIT---------------------------------------------*/

    /*-----------------------------ROTATE ARRAY---------------------------------------------*/
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }


    public static void reverse(int[] arr, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) swap(arr, i, j);
    }
    /*--------------------------------ROTATE ARRAY------------------------------------------*/


    /*--------------------------------Contains Duplicate------------------------------------------*/
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) if (!set.add(i)) return true;
        return false;
    }

    /*public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]) return true;
        }
        return false;
    }*/

    /*public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]) return true;
            }
        }
        return false;
    }*/
    /*--------------------------------Contains Duplicate------------------------------------------*/


    /*--------------------------------Single Number------------------------------------------*/
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
   /* public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i + 1 > nums.length - 1 || nums[i] != nums[i + 1]) return nums[i];
        }
        return -1;
    }*/
    /*--------------------------------Single Number------------------------------------------*/


    /*--------------------------------Intersection of Two Arrays II-----------------------------------------*/
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> arr = new ArrayList<>();

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                arr.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            if (nums1[i] > nums2[j]) j++;
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }
    /*--------------------------------Intersection of Two Arrays II-----------------------------------------*/


    /*--------------------------------Plus One-----------------------------------------*/
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) digits[i] = 0;
            else {
                digits[i] += 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /*public static int[] plusOne(int[] digits) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i = 0, j = digits.length - 1; i < digits.length && j >= 0; i++, j--) {
            bigInteger = bigInteger.add(BigInteger.valueOf(digits[j]).multiply(BigInteger.TEN.pow(i)));
        }
        bigInteger = bigInteger.add(BigInteger.ONE);
        return bigInteger.toString().chars().map(c -> c - '0').toArray();
    }*/
    /*--------------------------------Plus One-----------------------------------------*/


    /*--------------------------------Move Zeroes-----------------------------------------*/
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n - c; ) {
            while (nums[i] == 0 && n - c - 1 >= 0) {
                swapInRange(nums, i, n - 1);
                c++;
            }
            i++;
        }
    }
    /*--------------------------------Move Zeroes-----------------------------------------*/


    /*-----------------------------------------Two Sum-----------------------------------------*/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int delta;
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            delta = target - nums[i];
            if (hm.containsKey(delta)) {
                answer[0] = hm.get(delta);
                answer[1] = i;
                return answer;
            }
            hm.put(nums[i], i);
        }
        /*for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }*/
        return new int[0];
    }
    /*-----------------------------------------Two Sum-----------------------------------------*/

    /*-----------------------------------------Valid Sudoku-----------------------------------------*/
    public static boolean isValidSudoku(char[][] board) {
        return chekRow(board) && chekCol(board) && chekSubBoxes(board);
    }

    private static boolean chekSubBoxes(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) if (!checkForRepetition(board, i, j)) return false;
        }
        return true;
    }

    private static boolean checkForRepetition(char[][] board, int pointI, int pointJ) {
        int n = 3;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(board[pointI + i][pointJ + j] == '.') && !set.add(board[pointI + i][pointJ + j])) return false;
            }
        }
        return true;
    }

    private static boolean chekRow(char[][] board) {
        Set<Character> set;
        for (char[] chars : board) {
            set = new HashSet<>();
            for (char c : chars) if (!(c == '.') && !set.add(c)) return false;
        }
        return true;
    }

    private static boolean chekCol(char[][] board) {
        Set<Character> set;
        int n = board.length;
        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            for (char[] chars : board) if (!(chars[i] == '.') && !set.add(chars[i])) return false;
        }
        return true;
    }
    /*-----------------------------------------Valid Sudoku-----------------------------------------*/


    /*-----------------------------------------Rotate Image-----------------------------------------*/
    public static void rotate(int[][] matrix) {

    }
    /*-----------------------------------------Rotate Image-----------------------------------------*/
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Array @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * */

}
