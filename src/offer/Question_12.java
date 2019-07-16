package offer;

/**
 * 在字符矩阵中 匹配 指定字符串，只能向四周寻找，走过的字符不能再次访问
 */
public class Question_12 {

    private static boolean hasPath(char[][] matrix, int rows, int cols, String str){

        boolean[][] visited = new boolean[rows][cols];// 访问标志矩阵
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        int strIndex = 0;// 当前遍历的str字符下标
        // 每个字符都寻找一遍
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, i, j, str, strIndex, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    // 参数：矩阵  行数  列数  当前行  当前列  目标str  当前字符下标  访问标志矩阵
    private static boolean hasPath(char[][] matrix, int rows, int cols, int i, int j, String str, int strIndex, boolean[][] visited) {

        if (strIndex == str.length()) return true;// 如果字符下标越界，说明已经找到
        boolean result = false;

        // 行和列不能越界
        // 如果该行列对应的字符不匹配或该位置已访问过 直接返回false
        if (i >= 0 && i < rows && j >= 0 && j < cols && matrix[i][j] == str.charAt(strIndex) && !visited[i][j]){

            strIndex ++;// 匹配下一字符
            visited[i][j] = true;// 当前位置已访问过

            // 递归向四周寻找
            result = hasPath(matrix, rows, cols, i+1, j, str, strIndex, visited)
                    || hasPath(matrix, rows, cols, i-1, j, str, strIndex, visited)
                    || hasPath(matrix, rows, cols, i, j+1, str, strIndex, visited)
                    || hasPath(matrix, rows, cols, i, j-1, str, strIndex, visited);

            // 如果四周都返回false，退回到前一个目标字符，同时将访问标志恢复
            if (!result){
                --strIndex;
                visited[i][j] = false;
            }
        }

        return result;
    }
}
