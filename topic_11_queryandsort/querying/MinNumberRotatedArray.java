package topic_11_queryandsort.querying;

/**
 * @author wenyao
 * @create 2020-07-21 12:57
 * ^-^ Fighting!
 */

/*
思路：旋转数组的特点：最小值把数组分为两个递增子数组，使用二分查找法，mid把数组分成两半，最小值不在mid所在的递增数组中，这样逐渐缩小范围
当分割出来的子数组头和尾相邻时，便可终止循环，最小值就是array[end]
另外仍需考虑旋转数组就是原数组的情况
 */
public class MinNumberRotatedArray {
    public int minNumberInRotateArray(int array[]){
        int start = 0, end = array.length - 1;
        int mid = 0;   //考虑旋转数组就是原数组的情况
        while(array[start] >= array[end]){
            //循环结束的条件
            if(end - start == 1){
                mid = end;
                break;
            }
            mid = (start + end)/2;
            //如果出现start、end、mid的值相同的情况，则无法确定mid属于前递增数组还是后递增子数组
            //只能通过遍历的方法顺序查找
            if(array[start] == array[end] && array[start] == array[mid]){
                int ret = array[start];
                for(int i = start + 1; i <= end; i++){
                    if(array[i] < ret)
                        ret = array[i];
                }
                return ret;
            }

            if(array[mid] >= array[start]){
                //最小值在mid之后，mid属于前递增子数组
                start = mid;
            }

            if(array[mid] <= array[end]){
                //说明最小值在mid之前，mid属于后递增子数组
                end = mid;
            }
        }

        return array[mid];
    }
}
