import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "abcabc";
        //System.out.println("Output: " + reduceStr(str));
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples",
                new String[]{"#", "!"}));

    }

    private static int reduceStr(String input) {
        char[] arr = input.toCharArray();
        boolean doLoop;
        do {
            arr = loop(arr);
            doLoop = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    doLoop = true;
                    break;
                }
            }
        } while (doLoop);

        return arr.length;
    }

    private static char[] loop(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[i + 1] = getProperChar(arr[i], arr[i + 1]);
                arr[i] = ' ';
            }
        }
        int count = 0;
        for (char c : arr) if (c == ' ') count++;

        char[] newArr = new char[arr.length - count];

        int j = 0;
        for (char c : arr) {
            if (c != ' ') {
                newArr[j] = c;
                j++;
            }
        }
        return newArr;
    }

    private static char getProperChar(char c1, char c2) {
        char[] arr = {'a', 'b', 'c'};
        char c3 = ' ';
        for (char c : arr) if (c1 != c && c2 != c) c3 = c;
        return c3;
    }


    public static String stripComments(String text, String[] commentSymbols) {

        char[] arr = text.toCharArray();

        return "";
    }
}
