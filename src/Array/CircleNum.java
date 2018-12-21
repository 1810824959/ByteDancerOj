package Array;

public class CircleNum {
    public int findCircleNum(int[][] M) {
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

    public static void main(String[] args) {
        int[][] circle = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        CircleNum circleNum = new CircleNum();
        circleNum.findCircleNum(circle);
    }
}
