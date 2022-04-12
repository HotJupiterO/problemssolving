package leetcode.com.math;


import java.util.*;

/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ String @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * */
public class Solution {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(eratosfenPrimes(n));
    }

    /*-----------------------------Fizz Buzz---------------------------------------------*/
    public static List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) l.add("FizzBuzz");
            else if (i % 3 == 0) l.add("Fizz");
            else if (i % 5 == 0) l.add("Buzz");
            else l.add("" + i);
        }
        return l;
    }
    /*-----------------------------Fizz Buzz---------------------------------------------*/

    /*-----------------------------Count Primes---------------------------------------------*/
    public static int eratosfenPrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        int count = 0;
        for (var i = 2; i * i < max; i++) {
            if (!isPrime[i]) {
                count++;
                for (var j = 2 * i; j < max; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        /*for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) count++;
        }*/
        // for (boolean b:isPrime) if (!b) count++;
        return count * count;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    /*-----------------------------Count Primes---------------------------------------------*/

    public static boolean isPowerOfThree(int n) {
        while (n > 1) {
            int rem = n % 3;
            if (rem != 0) return false;
            n /= 3;
        }
        return n == 1;
        /*
        if (n == 1) return true;
        if (n <= 0 || n == 2) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return true;
        */
    }

    public static int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i > 0 && map.get(ch) > map.get(s.charAt(i - 1))) {
                result += map.get(ch) - 2 * map.get(s.charAt(i - 1));
            } else result += map.get(ch);
        }
        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ String @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * */