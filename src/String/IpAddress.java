package String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * res 返回可能的列表
 */
public class IpAddress {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s){
        generateIpAddress("",s);
        System.out.println(res);
        return res;
    }

    public void generateIpAddress(String ipAddressDone , String s){
        int n = 0;
        for (int i = 0; i<ipAddressDone.length();++i){    //得出ip地址已经分好 多少段了 用 n 表示
            if (ipAddressDone.charAt(i)=='.'){
                n++;
            }
        }
        if (n==3){
            String lastPart = s.substring(ipAddressDone.length()-n,s.length());
            if (lastPart.length()>3 || lastPart.length()<1){   // 最后剩下的一段超过3 位，或者不剩下了，没有了
                return;
            }
            if (lastPart.startsWith("0") && lastPart.length()>1){  //最后剩下个0开头的长字符串
                return;
            }
            //最后一段了，直接检验即可
            if (isValid(lastPart)){
                res.add(ipAddressDone+lastPart);
                return;
            }
        }
        if (n<3){
            for (int i=0; i<3 ;i++){
                if (ipAddressDone.length()-n+i+1<s.length()){   //防止，遍历到的下标，超出s 的长度，就会报错
                    String ipAddressToBeDone = s.substring(ipAddressDone.length()-n,ipAddressDone.length()-n+i+1);  //每次拿出 length 1-3 的数字字符串
                    if (ipAddressToBeDone.startsWith("0") && ipAddressToBeDone.length()==1){  //遇到单独一个零，就继续递归
                        generateIpAddress(ipAddressDone+"0"+".",s);
                        return;
                    }
                    if (ipAddressToBeDone.startsWith("0") && ipAddressToBeDone.length()>1){ //遇到零开头的，长字符串
                        return;
                    }
                    if (isValid(ipAddressToBeDone)){  //不是单独一个零
                        generateIpAddress(ipAddressDone+ipAddressToBeDone+".",s);
                    }
                }
            }
            return;
        }
    }

    public boolean isValid(String addressPart){    //进到这里来的时候，已经经过了 0 的筛选
            Integer addressPartInt = Integer.parseInt(addressPart);
            if (addressPartInt<=255){
                return true;
            }else {
                return false;
            }
    }

    public static void main(String[] args) {
        IpAddress dsa = new IpAddress();
        dsa.restoreIpAddresses("010010");
    }
}
