package leetcode.com.string;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] s = {"ab", "a"};
        System.out.println("Longest prefix is: " + longestCommonPrefix(s));
    }


    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ String @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
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

    private static char[] strToCharArrConverter(String[] board) {
        int n = board.length;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = board[i].charAt(0);
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int t : arr) System.out.print(t + " ");
        System.out.println();
    }

    private static void printArray(char[] arr) {
        for (char t : arr) System.out.print(t + " ");
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

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swapInRange(int[] nums, int from, int to) {
        for (int i = from; i < to; i++) swap(nums, i, i + 1);
    }
    /*-----------------------------UTILITY---------------------------------------------*/


    /*-----------------------------Reverse String---------------------------------------------*/
    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0, j = n; i < n / 2; i++, j--) {
            swap(s, i, j - 1);
        }
    }
    /*-----------------------------Reverse String---------------------------------------------*/

    /*-----------------------------Reverse Integer---------------------------------------------*/
    public static int reverse(int x) {
        long reversed = 0;
        long num = x;
        for (; num != 0; num /= 10) reversed = reversed * 10 + num % 10;
        return (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) ? 0 : (int) reversed;
        // return Integer.parseInt(String.valueOf(new StringBuilder(x + "").reverse()));
    }
    /*-----------------------------Reverse Integer---------------------------------------------*/

    /*-----------------------------First Unique Character in a String---------------------------------------------*/
    public static int firstUniqChar(String s) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = i;
            for (int j = 0; j < s.length(); j++) {
                if (j == i) continue;
                if (s.charAt(i) == s.charAt(j)) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) return index;
        }
        return index;
    }
    /*-----------------------------First Unique Character in a String---------------------------------------------*/

    /*-----------------------------Valid Anagram---------------------------------------------*/
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.compare(a, b) == 0;
    }
    /*-----------------------------Valid Anagram---------------------------------------------*/

    /*-----------------------------Valid Palindrome---------------------------------------------*/
    public static boolean isPalindrome(String s) {
        String result = s.replaceAll("[^\\p{L}\\p{N}]+", "").toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(result);
        return sb.reverse().toString().equals(result);
    }
    /*-----------------------------Valid Palindrome---------------------------------------------*/


    /*-----------------------------String to Integer (atoi)---------------------------------------------*/
    public static int myAtoi(String s) {
        char[] str = s.toCharArray();
        int sign = 1;
        int atoi = 0;
        int i = 0;

        while (i < str.length && str[i] == ' ') i++; //skip whitespaces
        if (i < str.length && (str[i] == '-' || str[i] == '+'))
            sign = 1 - 2 * (str[i++] == '-' ? 1 : 0); //sign of digit
        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            if (atoi > Integer.MAX_VALUE / 10 || (atoi == Integer.MAX_VALUE / 10 && str[i] - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            atoi = atoi * 10 + (str[i++] - '0');
        }
        return atoi * sign;
    }
    /*-----------------------------String to Integer (atoi)---------------------------------------------*/

    /*-----------------------------Implement strStr()---------------------------------------------*/
    public static int strStr(String haystack, String needle) {
        int[] pi = new int[needle.length()];
        char[] hs = haystack.toCharArray();
        char[] ndl = needle.toCharArray();
        pi[0] = 0;
        for (int i = 1, j = 0; i < ndl.length; ) {
            if (ndl[i] == ndl[j]) {
                pi[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                pi[i] = 0;
                i++;
            } else j = pi[j - 1];
        }

        int j = 0;
        for (int i = 0; i < hs.length; i++) {
            while (j > 0 && hs[i] != ndl[j]) j = pi[j - 1];
            if (hs[i] == ndl[j]) {
                j++;
                if (j == ndl.length) return i - (j - 1);
            }
        }
        return -1;

        /*if (needle.length() == 0 || haystack == null ) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            for (int j = 0, k = i; j < needle.length() && k < haystack.length(); j++, k++) {
                if (haystack.charAt(k) != needle.charAt(j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;*/
    }
    /*-----------------------------Implement strStr()---------------------------------------------*/

    /*-----------------------------Longest Common Prefix---------------------------------------------*/
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        for (String s : strs) System.out.println(s);
        String pattern = strs[0];
        int n = pattern.length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != pattern.charAt(i)) {
                    return i > 0 ? pattern.substring(0, i) : "";
                }
            }
            if (i == n - 1) return pattern;

        }
        return "6";
    }

    /*-----------------------------Longest Common Prefix---------------------------------------------*/

}


/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ String @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * */