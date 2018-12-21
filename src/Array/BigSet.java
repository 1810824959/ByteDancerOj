package Array;

import java.util.BitSet;
public class BigSet {
    public static void main(String[] args) {
        BitSet bitSet=new BitSet();
        int[] nums={1,2,3,4,5,6,1};

        for (int num : nums) {
            if(bitSet.get(num)){
                System.out.println(num);
                break;
            }else {
                bitSet.set(num);
            }
        }
    }
}
