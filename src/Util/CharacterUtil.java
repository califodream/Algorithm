package Util;

public class CharacterUtil {

    public static void main(String[] args) {
        CharacterUtil util = new CharacterUtil();
        String result = util.reverse("world".toCharArray());
        System.out.println(result);
    }

    /**
     *
     * @param str
     * @return
     */
    public String reverse(String str) {
        return reverse(str.toCharArray());
    }

    /**
     * Memory:  45M, Timing: 1ms
     * @param charArray
     * @return
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
