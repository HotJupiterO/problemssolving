package leetcode.com.math;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        final int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 4, 9};
        System.out.println("=======TopTFreq=======");
        System.out.println("Input array: " + Arrays.toString(b));
        System.out.println(Arrays.toString(topKFrequent(b, 2)));
        Queue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int i : b) priorityQueue.offer(i);
        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()) System.out.printf("%d ", priorityQueue.poll());

    }

    /*-----------------------------Fizz Buzz---------------------------------------------*/
    public static List<String> fizzBuzz(int n) {
        final List<String> l = new ArrayList<>();
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
        final boolean[] isPrime = new boolean[max + 1];
        int count = 0;
        for (var i = 2; i * i < max; i++) {
            if (!isPrime[i]) {
                count++;
                for (var j = 2 * i; j < max; j += i) {
                    isPrime[j] = true;
                }
            }
        }
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
        final Map<Character, Integer> map = new HashMap<>();
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

    // 1,2,3,4,5
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int len1 = nums1.length, len2 = nums2.length;
        final int l = len1 + len2;
        final int[] mergedArray = new int[l];
        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            mergedArray[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < len1) mergedArray[k++] = nums1[i++];
        while (j < len2) mergedArray[k++] = nums2[j++];
        return l % 2 == 0 ? ((double) (mergedArray[(l >> 1) - 1] + mergedArray[l >> 1]) / 2d) : mergedArray[l >> 1];
    }

    /*-----------------------------Top K Frequent Elements---------------------------------------------*/
    public static int[] topKFrequent(int[] nums, int k) {
        final int[] answer = new int[k];
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int[][] frequencyArray = new int[frequencyMap.size()][2];

        var index = 0;
        for (var key : frequencyMap.keySet()) {
            var val = frequencyMap.get(key);
            frequencyArray[index][0] = val;
            frequencyArray[index][1] = key;
            index++;
        }
        Arrays.sort(frequencyArray, (b, a) -> Integer.compare(a[0], b[0]));
        for (var i = 0; i < k; i++) answer[i] = frequencyArray[i][1];

        return answer;
    }
    /*-----------------------------Top K Frequent Elements---------------------------------------------*/


    /*-----------------------------Radix Sort---------------------------------------------*/


    public static int[] radixSort(int[] nums) {
        final var capacity = 10;
        final Map<Integer, Queue<Integer>> map = new HashMap<>(capacity);
        for (var i = 0; i < capacity; i++) map.put(i, new LinkedList<>());
        final var maxValue = getMax(nums);
        var multiplier = 1;
        while (maxValue - multiplier >= 0) {
            for (var num : nums) {
                int slice = num / multiplier;
                map.get(slice % capacity).add(num);
            }
            int index = 0;
            for (var i = 0; i < capacity; i++) {
                while (!map.get(i).isEmpty()) {
                    nums[index++] = map.get(i).remove();
                }
            }
            multiplier *= capacity;
        }
        return nums;
    }

    public static int getMax(int[] nums) {
        var max = 0;
        for (var num : nums) if (num > max) max = num;
        return max;
    }
    /*-----------------------------Radix Sort---------------------------------------------*/


}
