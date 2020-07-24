package topic_12_backtracking;

/**
 * @author wenyao
 * @create 2020-07-24 17:38
 * ^-^ Fighting!
 */

/**
 * 寻找这个操作用递归没跑了
 * 回溯回溯的是节点有没有被访问的标记。
 * 递归时能返回true的情况有两个 1：pathLen到了；2：找到自己的后继了
 */
public class StringPathInMatrix {

    //这三个变量都可以不要，只是作者的一家之言。
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix,str,marked,0,i,j))
                    return true;
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == str.length)
            return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || matrix[r][c] != str[pathLen] || marked[r][c])
            return false;
        marked[r][c] = true;
        for (int[] n : next){
            if(backtracking(matrix,str,marked,pathLen+1,r+n[0],c+n[1]))
                return true;
        }
        marked[r][c] = false;
        return false;

    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
    }
}
