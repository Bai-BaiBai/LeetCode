package offer;

/**
 * 机器人运动范围
 *
 * m*n矩阵，机器人从(0,0)开始向四周移动，只能进入行坐标和列坐标数位之和小等于k的格子
 *
 * 例如：k=18 能够进入(35,37) 因为3+5+3+7=18
 * 求机器人所能到达的格子数
 */
public class Question_13 {

    //回溯法
    public int count(int[][] arr, int threshold, int rows, int cols){

        boolean[][] visited = new boolean[rows][cols];// 访问标志矩阵
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        return movingCount(threshold, rows, cols, 0, 0, visited);
    }

    // 递归计算可进入的格子
    // row和col为当前位置坐标
    private int movingCount(int threshold, int rows, int cols, int row, int col, boolean[][] visited){

        int count = 0;// 假设当前格子不能进入

        // 检查
        if (check(threshold,rows,cols, row, col, visited)){

            // 当前格子可进入
            visited[row][col] = true;
            count ++;
            // 再加上四周的可进入格子数
            count += movingCount(threshold, rows, cols, row+1, col, visited)
                    + movingCount(threshold, rows, cols, row-1, col, visited)
                    + movingCount(threshold, rows, cols, row, col+1, visited)
                    + movingCount(threshold, rows, cols, row, col-1, visited);
        }
        return count;
    }

    // 检查当前格子的合法性 是否小于阈值
    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited){

        return row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]
                && getDigit(row) + getDigit(col) <= threshold;
    }

    // 计算坐标的数位和
    private int getDigit(int number){

        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}