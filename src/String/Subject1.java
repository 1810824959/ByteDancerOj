package String;

import java.util.ArrayList;

/**
 * 找出其中不含有重复字符的 最长子串 的长度
 */
public class Subject1 {
    public int lengthOfLongestSubstring(String s) {
        ArrayList list = new ArrayList();
        int length = 0;

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if ( ! list.contains(c)){  //不在list
                if (index==s.length()-1){
                    list.add(c);
                    length = length>list.size() ? length:list.size();
                }
                else {
                    list.add(c);
                }
            }
            else {
                if (list.size()>length){
                    length = list.size();
                }
                int i = list.indexOf(c);
                for(int x=0;x<=i;x++){
                    list.remove(0);
                }
                list.add(c);

            }
        }
        return length;
    }
    public int test2(String s){
        int length = s.length(), ans = 0;
        int[] array = new int[128];
        for (int i = 0, j = 0; i < length; i++){
            j = Math.max(array[s.charAt(i)], j);
            ans = Math.max(ans, i - j + 1);
            array[s.charAt(i)] = i + 1;
        }
        return ans;
    }
}
