package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * recipe 先排序，并合并相同数字，减少时间复杂度，和不必要的运算
 * 快速排序，冒泡排序，合并
 */
public class Sum0 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] numsOrigin) {
        int[] nums = sort(numsOrigin);
        for (int i=0 ; i<nums.length-2 ; i++){
            for (int j = i+1 ;j<nums.length ; j++){
                for (int k = j+1 ; k<nums.length ; k++){
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }else {
                        continue;
                    }
                }
            }
        }
        System.out.println(lists);

        return lists;
    }

    private void removeAllSame(List<Integer> list1,List<Integer> list2){

    }
    private int[] sort(int[] nums){
        for (int j =0 ; j<nums.length ; j++) {
            for (int i = 0; i < nums.length - 1 - j; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        return nums;
//        List<Integer> list=new ArrayList<>();
//        for (int i=0;i<nums.length;i++){
//            if (!list.contains(nums[i])){
//                list.add(nums[i]);
//            }
//        }
//
//        int[] need=new int[list.size()];
//        int i=0;
//        for (int item:list) {
//            need[i]=item;
//            i++;
//        }
//        return need;
    }

    public static void main(String[] args) {
        Sum0 sum0 = new Sum0();
        int nums[]={-1, 0, 1, 2, -1, -4};
        sum0.threeSum(nums);
//       int[] sda = sum0.sort(nums);
//        for (int i =0;i<sda.length;i++){
//            System.out.println("dsa"+nums[i]);
//        }
    }
}
