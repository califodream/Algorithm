package Util;

import java.util.Arrays;

/**
 * 升序排序
 */
public class SortUtil {

    public static void main(String[] args) {
        int[] array1 = new int[]{8, 6, 2, 3, 1, 5, 7, 4};
        int[] array2 = new int[]{8, 6, 2, 2, 1};
        int[] array3 = new int[]{1, 2, 8, 6};
        insertedSortE2(array1);
        System.out.println(Arrays.toString(array1));
    }

    /**
     * 选择排序在任何情况下都是不推荐的
     */
    public static void selectedSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            if (i != minIndex) {
                swap(array, i, minIndex);
            }
        }
    }

    /**
     * 对于大部分有序的数组来说，使用插入排序会快一些
     */
    public static void insertedSortE1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    /**
     * 通过增加空间开销保留需要比较的数据，并将交换操作优化为赋值操作对插入排序进行优化
     */
    public static void insertedSortE2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            int temp = array[j];
            for (; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    /**
     *
     */
    public static void splitOfMergeSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        double midDouble = Math.floor(Integer.valueOf((left + right) / 2).doubleValue());
        int midInteger = Double.valueOf(midDouble).intValue();
        splitOfMergeSort(array, left, midInteger);
        splitOfMergeSort(array, midInteger + 1, right);
        mergeOfMergeSort(array, left, midInteger, right);
    }

    /**
     *
     */
    public static void mergeOfMergeSort(int[] array, int left, int mid, int right) {

    }

    /**
     * 使用位运算原地交换数值
     */
    public static void swap(int[] array, int a, int b) {
        array[a] ^= array[b];
        array[b] ^= array[a];
        array[a] ^= array[b];
    }
}
