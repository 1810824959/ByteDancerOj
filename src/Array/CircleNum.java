package Array;

import java.util.ArrayList;
import java.util.List;

public class CircleNum {
    private List<List<Integer>> lists = new ArrayList<>();

    public int findCircleNum_1(int[][] M) {
        int num = 0;
        for (int i = 0 ; i<M.length ; i++){
            for (int j = 0 ; j<M[0].length ; j++){
                if (M[i][j]==1){
                    generate(M,i,j);
                    num++;
                }
            }
        }
        System.out.println(num);
        return num;
    }

    private void generate(int[][] M,int i ,int j){
        if (i<0 || i>M.length-1 || j<0 || j>M[0].length-1 || M[i][j]==0){
            return;
        }
        M[i][j]=0;
        generate(M,i+1,j);
        System.out.println("上");
        generate(M,i-1,j);
        System.out.println("下");
        generate(M,i,j+1);
        generate(M,i,j-1);
    }

    public int findCircleNum(int[][] M) {
        return method2(M);
    }
    /*
        初始时每个个体的根朋友为自己本身，若M[i][j] == 1，说明i 和 j是朋友，找到i的根朋友i_parent和j的根朋友j_parent，
        若两者根朋友一样说明是一个朋友圈，不做操作；若两者根朋友不一样，说明是不同的朋友圈，则执行合并朋友圈的操作，将j的根朋友
        j_parent的根朋友设置为i的根朋友i_parent，总数减一
    */
    public int method2(int[][] M){
        int count = M.length;
        int[] help = new int[M.length];
        for(int i = 0;i < help.length;i++)
            help[i] = i;
        for(int i = 0;i < M.length;i++){
            for(int j = i + 1;j < M.length;j++){
                if(M[i][j] == 1){
                    int i_parent = findParent(help,i);
                    int j_parent = findParent(help,j);
                    if(i_parent != j_parent){
                        help[j_parent] = i_parent;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public int findParent(int[] help,int id){
        if(help[id] == id)
            return id;
        return findParent(help,help[id]);
    }

    public static void main(String[] args) {
        int[][] circle = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        CircleNum circleNum = new CircleNum();
        circleNum.findCircleNum(circle);
    }
}
