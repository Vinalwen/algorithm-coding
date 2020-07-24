package topic_11_queryandsort.sorting;

/**
 * @author wenyao
 * @create 2020-07-22 12:52
 * ^-^ Fighting!
 */
public class InsertionSort {
    //算法类不允许产生任何实例
    private InsertionSort(){};

    /*
    * 插入排序的思路:
    1.每一个数字都和它之前的数字的数字作比较，如果前面的数字更大，则把前面的数字往后挪一个
    2.直到前面的数字遍历完了(也就是这个数字是最小的)、或者是遇到比自己小的数字了，则退出循环，并将自己赋值给当前索引
    * O(n^2)
    * */

    public static void sort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            int j = i;
            Comparable e = arr[i];
            for(; j > 0 && arr[j-1].compareTo(e) > 0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = SortTestHelper.generateRandomArray(12,5,100);
        InsertionSort.sort(arr);
        System.out.println(SortTestHelper.isSorted(arr));


    }
}