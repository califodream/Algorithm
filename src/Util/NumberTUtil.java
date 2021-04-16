package Util;

public class NumberTUtil {

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 2, 7, 8, 4};
        System.out.println(NumberTUtil.distantPeak(a));
    }

    /**
     * Memory: 35.6M
     * No Cache
     */
    public static int fibonacci(int n) {
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

    /**
     * 找出数组中最大的值的索引
     */
    public static int max(int[] numArray) {
        int tail = numArray.length - 1;
        int head = 0;
        while (head < tail) {
            if (numArray[tail] >= numArray[head])
                head++;
            else
                tail--;
        }
        if (numArray[tail] >= numArray[head])
            return tail;
        else return head;
    }

    /**
     *
     */
    public static int distantPeak(int[] numArray) {
        int head = numArray.length;
        int tail = -1;
        int index = head - 1;
        while (index > -1) {
            if (index + 1 == head) {
                if (numArray[index] > numArray[index - 1])
                    break;
                else {
                    index--;
                    continue;
                }
            }
            if (index - 1 == tail) {
                if (numArray[index] > numArray[index + 1])
                    break;
                else {
                    index--;
                    continue;
                }
            }
            if (numArray[index] > numArray[index - 1] && numArray[index] > numArray[index + 1])
                break;
            else
                index--;
        }
        return index;
    }
}
