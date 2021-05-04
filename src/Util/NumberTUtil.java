package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberTUtil {

    public static void main(String[] args) {
        int[] a = {2, 6, 4, 8, 10, 9, 15};
        int[] b = {1, 2, 3, 4};
        int[] c = {0};
        int[] d = {2, 4, 10, 8};
        System.out.println(unsortedSubArray(a));
    }

    /**
     * LeetCode-剑指offer 10-I
     * Memory: 35.6MB
     * No Cache
     * 输出斐波那契数列中指定索引里的数值
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
     * Nowcoder NC107
     * Timing: 20ms Memory: 11MB
     * TODO: 有待优化
     * 获得数组中最远的山峰
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

    /**
     * Nowcoder NC38
     * 螺旋输出矩阵中的值
     * Timing: 33ms
     * Memory: 10.8MB
     */
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

    /**
     * Nowcoder NC110
     * Timing: 25ms
     * Memory: 10.6MB
     * 旋转数组
     */
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

    /**
     * Timing: 28ms Memory: 10MB
     */
    public static int[] twoSums(int[] array, int target) {
        int index = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (; index <= array.length; index++) {
            if (hashMap.containsKey(target - array[index - 1]))
                break;
            hashMap.put(array[index - 1], index);
        }
        return new int[]{hashMap.get(target - array[index - 1]), index};
    }

    public static int unsortedSubArray(int[] array) {
        int head = 0;
        int tail = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean check = false;
        for (int index = 1; index < tail; index++) {
            if (array[index] < array[index - 1]) {
                check = true;
            }
            if (check) {
                min = Math.min(min, array[index]);
                max = Math.max(max, array[index - 1]);
                check = false;
            }
        }
        int left = 0, right = tail - 1;
        for (; left < tail; left++) {
            if (array[left] > min)
                break;
        }
        for (; right >= head; right--) {
            if (array[right] < max)
                break;
        }
        return right - 1 >= 0 ? right - left + 1 : 0;
    }
}
