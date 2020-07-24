package topic_3_array;

/**
 * @author wenyao
 * @create 2020-07-09 17:09
 * ^-^ Fighting!
 */
public class DuplicationInArray {
//    public void arrayRepeatedNumbers1(){
//
//    }



    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
        int[] num ={1,4,2,5,7,2};


    }

}
