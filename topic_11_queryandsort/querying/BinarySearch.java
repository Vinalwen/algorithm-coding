package topic_11_queryandsort.querying;

/**
 * @author wenyao
 * @create 2020-07-21 12:17
 * ^-^ Fighting!
 */


// https://blog.csdn.net/u014017322/article/details/80883712 配合图
    //在一个排好序的数组中找到某个值的位置
public class BinarySearch {
    public int binSearch(int[] arr, int key){
        int start = 0, end = arr.length;
        int mid = (start + end)/2;
        while (start <= end){
            if (arr[mid] == key)
                return mid;
            else if(key > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
            mid = (start + end)/2;
        }
        return -1;
    }
}
