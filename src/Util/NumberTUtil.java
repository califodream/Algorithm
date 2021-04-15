package Util;

public class NumberTUtil {

    public static void main(String[] args) {
        NumberTUtil util = new NumberTUtil();
        System.out.println(util.fibonacci(45));
    }

    /**
     * Memory: 35.6M
     * No Cache
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        int back = 0;
        int front = 1;
        if (n < 0) return 0;
        if (n < 2) return n;
        int index = 2;
        int temp;
        while (index <= n) {
            temp = back % 1000000007;
            back = front % 1000000007;
            front = back + temp;
            index++;
        }
        return front % 1000000007;
    }
}
