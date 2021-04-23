package Util;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberTUtil {

    public static void main(String[] args) {
        int[] matrix = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(NumberTUtil.spinArray(2, matrix)));
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
     * Timing: 20ms Memory: 11M
     * TODO: 有待优化
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

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> orderList = new ArrayList<>();
        int[][] directionsMatrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];
        int rowIndex = 0, columnIndex = 0;
        int nextRow = 0, nextColumn = 0;
        int directionIndex = 0;
        for (int index = 0; index < matrix.length * matrix[0].length; index++) {
            orderList.add(matrix[rowIndex][columnIndex]);
            visitedMatrix[rowIndex][columnIndex] = true;
            nextRow = rowIndex + directionsMatrix[directionIndex][0];
            nextColumn = columnIndex + directionsMatrix[directionIndex][1];
            if (nextRow >= matrix.length || nextRow < 0 || nextColumn >= matrix[0].length || nextColumn < 0 || visitedMatrix[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            rowIndex += directionsMatrix[directionIndex][0];
            columnIndex += directionsMatrix[directionIndex][1];
        }
        return orderList;
    }

    public static int[] spinArray(int step, int[] array) {
        int length = array.length;
        step = step % length;
        int round = gcd(step, length);
        for (int count = 0; count < round; count++) {
            int index = count;
            int temp1 = array[index];
            do {
                int nextIndex = (index + step) % length;
                int temp2 = array[nextIndex];
                array[nextIndex] = temp1;
                temp1 = temp2;
                index = nextIndex;
            } while (index != count);
        }
        return array;
    }

    /**
     * Least Common Multiple
     */
    public static int lcm(int n, int k) {
        int c = n * k;
        int r;
        while (true) {
            r = n % k;
            if (r == 0) {
                break;
            } else {
                n = k;
                k = r;
            }
        }
        return c / k;
    }

    /**
     * Greater Common Divisor
     */
    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
