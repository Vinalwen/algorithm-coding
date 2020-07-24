package topic_11_queryandsort.sorting;

import sun.security.util.Length;

/**
 * @author wenyao
 * @create 2020-07-23 20:37
 * ^-^ Fighting!
 */

/**
 * 假设长度为n的数组arr，要按照从小到大排序。则冒泡排序的具体过程可以描述为：
 * 首先从数组的第一个元素开始到数组最后一个元素为止，对数组中相邻的两个元素进行比较
 * 如果位于数组左端的元素大于数组右端的元素，则交换这两个元素在数组中的位置
 * 此时数组最右端的元素即为该数组中所有元素的最大值。
 * 接着对该数组剩下的n-1个元素进行冒泡排序，直到整个数组有序排列。
 * 算法的时间复杂度为O(n^2)。
 */
public class BubbleSort {
    // 我们的算法类不允许产生任何实例
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0)
                    swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Comparable[] arr = SortTestHelper.generateRandomArray(12, 5, 100);
        BubbleSort.sort(arr);
        System.out.println(SortTestHelper.isSorted(arr));


    }

}
