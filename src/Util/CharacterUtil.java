package Util;

public class CharacterUtil {

    public static void main(String[] args) {
        CharacterUtil util = new CharacterUtil();
        String result = util.reverse("world");
        System.out.println(result);
    }

    /**
     *
     */
    public String reverse(String str) {
        return reverse(str.toCharArray());
    }

    /**
     * Memory:  45M, Timing: 1ms
     *
     */
    public String reverse(char[] charArray) {
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
}
