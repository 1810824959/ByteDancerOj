package Array;

public class binarySearch_1 {
    public int search(int[] nums, int target) {
        //寻找出旋转长度；
        int lo=0,hi=nums.length-1;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>nums[hi]){
                lo = mid+1;
            }
            else{
                hi = mid;  //这里不能有减一操作，因为nums[mid] 有可能是最小值；
            }
        }
        // System.out.println(lo);
        int rot = lo;
        lo=0;
        hi=nums.length-1;
        //对mid也进行旋转来直接使用二分查找
        while(lo<=hi){
            int mid =(lo+hi)/2;
            int realMid = (mid+rot)%nums.length; // 对mid进行逻辑上的旋转
            if(nums[realMid] == target) return realMid;
            else if(nums[realMid]<target)
                lo = mid+1;  //注意最后赋值是mid,而非旋转后的realMId
            else
                hi = mid-1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,-1,0,1,2,3};
        binarySearch_1 binarySearch = new binarySearch_1();
        int search = binarySearch.search(nums, 2);
        System.out.println(search);
    }
}
