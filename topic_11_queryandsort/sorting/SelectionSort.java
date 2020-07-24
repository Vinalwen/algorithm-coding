package topic_11_queryandsort.sorting;

/**
 * @author wenyao
 * @create 2020-07-22 13:46
 * ^-^ Fighting!
 */

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 选择排序的思路：每一趟在n-i+1(i=1,2,...,n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。
 * O(n^2)
 */

public class SelectionSort {
    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}

    public static void sort(Comparable[] arr){
        for (int i= 0;i < arr.length;i++){
            int minIndex = i;
            for (int j = i+1;j < arr.length;j++){

                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr,i,minIndex);

        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Comparable[] arr = SortTestHelper.generateRandomArray(12,5,100);
        SelectionSort.sort(arr);
        System.out.println(SortTestHelper.isSorted(arr));


    }
}
