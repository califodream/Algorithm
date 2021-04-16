package Util;

import java.util.Arrays;

public class CharacterUtil {

    public static void main(String[] args) {
        String test = "race a car";
        System.out.println(CharacterUtil.isPalindromeForCaseUnSenseNBlank(test));
    }

    /**
     * 将字符串反转
     */
    public static String reverse(String str) {
        return reverse(str.toCharArray());
    }

    /**
     * Memory:  45M, Timing: 1ms
     * 将字符串数组反转
     */
    public static String reverse(char[] charArray) {
        int tail = charArray.length - 1;
        int head = 0;
        char temp;
        while (head < tail) {
            temp = charArray[head];
            charArray[head] = charArray[tail];
            charArray[tail] = temp;
            head++;
            tail--;
        }
        return new String(charArray);
    }

    /**
     * Timing: 90ms Memory: 21M
     * 属于Easy版本，该字符串中不包括空格，同时该算法大小写敏感
     */
    public static boolean isPalindromeForCaseUnSenseNNoPunctuate(String str) {
        int head = str.length() - 1;
        for (int tail = 0; tail <= head; tail++, head--) {
            if (str.charAt(tail) != str.charAt(head)) return false;
        }
        return true;
    }

    /**
     * Timing: 2ms Memory: 38.4MB
     */
    public static boolean isPalindromeForCaseUnSenseNBlank(String s) {
        int head = s.length() - 1;
        int tail = 0;
        char headChar;
        char tailChar;
        while (tail <= head) {
            headChar = s.charAt(head);
            tailChar = s.charAt(tail);
            if (!((headChar >= '0' && headChar <= '9') || (headChar >= 'a' && headChar <= 'z') || (headChar >= 'A' && headChar <= 'Z'))) {
                head--;
                continue;
            }
            if (!((tailChar >= '0' && tailChar <= '9') || (tailChar >= 'a' && tailChar <= 'z') || (tailChar >= 'A' && tailChar <= 'Z'))) {
                tail++;
                continue;
            }
            if (headChar >= 'A' && headChar <= 'Z')
                headChar += 32;
            if (tailChar >= 'A' && tailChar <= 'Z')
                tailChar += 32;
            if (headChar != tailChar)
                return false;
            tail++;
            head--;
        }
        return true;
    }
}
