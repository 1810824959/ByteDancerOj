package Array;

public class binarySearch {
    public int search(int[] nums, int target) {
        if (nums.length==0){return -1;}
        if (nums.length==1){return target==nums[0]?0:-1;}
        if (nums.length==2){
            if (target>nums[0]){
                return target==nums[1]?1:-1;
            }
            if (target<nums[0]){return -1;}
            return 0;
        }
        int first = 0 , last = nums.length-1;
        int point = findPoint(nums, first, last);
        if (point==0){   //不需要二分，因为就是升序
            return searchInOrderArray(nums,first,last,target);
        }

        if (target<nums[first]){ //比第一个小，那就在后面的一段里
            if (target<nums[point] || target>nums[last]){ // 越界
                return -1;
            }
            return searchInOrderArray(nums,point,last,target);
        }
        if (target>nums[point+1]){return -1;}

        return searchInOrderArray(nums,first,point-1,target);
    }

    private int findPoint(int[] nums, int begin, int stop){
        if (stop-begin<=2){
            if (stop-begin==1){ //待判断的只有两个
                return nums[begin]>nums[stop] ? stop:begin;
            }else {    //有三个
                if (nums[(stop+begin)/2]<nums[begin]){
                    return (begin+stop)/2;
                }else {
                    return (begin+stop)/2-1;
                }
            }
        }
        if (nums[(stop+begin)/2]<nums[begin]){ //右边是有序的
            return findPoint(nums, begin, (stop + begin) / 2 - 1);
        }else {  //左边是有序的
            return findPoint(nums, (stop + begin) / 2 + 1, stop);
        }
    }

    private int searchInOrderArray(int[] nums, int begin, int stop,int target){
        if (begin==stop){   //上一次递归处理，只有两个数
            return target==nums[begin]?begin:-1;
        }
        if (target==nums[(stop+begin)/2]){return (stop+begin)/2;}
        if (target>nums[(stop+begin)/2]){
            return searchInOrderArray(nums,(stop+begin)/2+1,stop,target);
        }else {
            return searchInOrderArray(nums,begin,(stop+begin)/2-1,target);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,3,5};
        binarySearch binarySearch = new binarySearch();
        binarySearch.search(nums,2);
    }
}
