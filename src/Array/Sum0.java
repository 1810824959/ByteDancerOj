package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * recipe 先排序，不能合并相同数字，减少时间复杂度，和不必要的运算
 * 快速排序，冒泡排序，合并
 */
public class Sum0 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] numsOrigin) {
        int[] nums = sort(numsOrigin);
        for (int i=0 ; i<nums.length-2 ; i++){
            for (int j = i+1 ;j<nums.length-1 ; j++){
                for (int k = j+1 ; k<nums.length ; k++){
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (lists.size()>0){
                            for (int m = 0; m<lists.size();m++){
                                if (!judgeSame(list,lists.get(m))){
                                    if (m==lists.size()-1){
                                        lists.add(list);
                                    }
                                }else {
                                    break;
                                }
                            }
                        }else {
                            lists.add(list);
                        }
                    }else {
                        continue;
                    }
                }
            }
        }
        System.out.println(lists);
        return lists;
//        System.out.println(lists);
//        Set<List<Integer>> set  =new HashSet<>(lists);
//        List<List<Integer>> listsNew = new ArrayList<>(set);
//        int index = 0 ,nIndex =1;
//        List<List<Integer>> listsNew = generateRemove(lists,index,nIndex);
//        System.out.println(listsNew);
//        return listsNew;
    }

    private List<List<Integer>> generateRemove(List<List<Integer>> lists , int index){
        for (int i = index ;i<lists.size()-1;i++){
            for (int j = i+1;j<lists.size() ; j++){
                if (judgeSame(lists.get(i),lists.get(j))){
                    lists.remove(j);
                    if (i+1<lists.size()){
                        generateRemove(lists,i);
                    }else {
                        return lists;
                    }
                }
            }
        }
        return lists;
    }
    private Boolean judgeSame(List<Integer> list1,List<Integer> list2){
        if (list1.size()==list2.size()){
            for (int i=0 ;i<list1.size();i++){
                if (list1.get(i).compareTo(list2.get(i))!=0){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }


    /**
     * 冒泡排序
     * @param nums
     * @return
     */
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
        int nums[]={3,0,-2,-1,1,2};
        sum0.threeSum(nums);
//       int[] sda = sum0.sort(nums);
//        for (int i =0;i<sda.length;i++){
//            System.out.println("dsa"+nums[i]);
//        }
    }
}
