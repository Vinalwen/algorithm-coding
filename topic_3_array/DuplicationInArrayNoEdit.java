package topic_3_array;

/**
 * @author wenyao
 * @create 2020-07-12 12:28
 * ^-^ Fighting!
 */
public class DuplicationInArrayNoEdit
{
    public int duplicate(int[] nums, int length, int[] duplication) {
        if (nums.length < 1)
            return -1;
        int start = 1;
        int end = length - 1;
        int middle;
        int count;
        while(end >= start){
            middle = (end - start)/2 + start;
            count = countRange(nums,length,start,middle);
            if (end == start){
                if(count > 1)
                    return start;
                else
                    break;
            }
            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }

        return -1;
    }

    public int countRange(int[] nums, int length, int start, int end){
        int count = 0;
        for (int i = 0;i < length;i++){
            if (nums[i] >= start && nums[i] <= end)
                ++count;
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
