package String;

import java.util.*;

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

    /**
     * 简化路径
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        // Write your code here
        String s = path.replaceAll("//", "/");
        String[] Names = s.split("/");
        Stack<String> S = new Stack<String>();
        for (int i = 0; i < Names.length; ++i) {
            if (".".equals(Names[i]) || "".equals(Names[i]))
                continue;
            if ("..".equals(Names[i])) {
                if (!S.empty())   //考虑了边界，，不能在空的时候 pop
                    S.pop();
            } else
                S.push(Names[i]);
        }
        StringBuilder R = new StringBuilder();
        while (!S.empty()) {
            R.insert(0, S.pop());
            R.insert(0, "/");
        }
        if (R.length() == 0)
            R.append("/");
        return R.toString();
    }

    public void test(){
        TreeSet ts=new TreeSet(new CompareByLen());
        ts.add("orange");
        ts.add("apple");
        ts.add("banana");
        ts.add("grape");


        Iterator it=ts.iterator();
        while(it.hasNext())
        {
            String fruit=(String)it.next();
            System.out.println(fruit);
        }
    }

    public void test3(){

    }
}

class CompareByLen /*extends Object*/ implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {        //按照字符串的长度比较
        int num = s1.length() - s2.length();        //长度为主要条件
        return num == 0 ? s1.compareTo(s2) : num;    //内容为次要条件
    }
}