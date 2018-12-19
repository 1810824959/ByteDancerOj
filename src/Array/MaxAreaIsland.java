package Array;

public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max =0;
        for (int i = 0 ;i<grid.length;++i){
            for (int j = 0 ;j<grid[0].length ;++j){
                if (grid[i][j]==1){
                    max = Math.max(max,generate(grid,i,j));
                }
            }
        }
        System.out.println(max);
        return max;
    }
    private int generate(int[][] grid ,int i ,int j){
        if (i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1){  //应该是i j 大于 length-1 ，因为Length=4,下标最多只到3 ，当i = 4 时，会越界，但还是执行了
            return 0;
        }
        if (grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+ generate(grid,i+1,j)+generate(grid,i-1,j)+generate(grid,i,j+1)+generate(grid,i,j-1);
    }

    public static void main(String[] args) {
        int num[][] = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        MaxAreaIsland maxAreaIsland = new MaxAreaIsland();
        maxAreaIsland.maxAreaOfIsland(num);
    }
}
