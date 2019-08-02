package offer;

/**
 * 顺时针打印矩阵
 *
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 */
public class Question_29 {

    private static void printMatrixClockwisely(int[][] arr, int rows, int columns){

        if (rows <= 0 || columns <= 0) return;

        int start = 0;
        // 策略是每次打印一圈，第一圈的起始点是(0,0) 第二圈的起始点是(1,1) 只要起始点*2小于行列数时 就可以继续打印
        while (rows > start*2 && columns > start*2){

            printMatrixCircle(arr, rows, columns, start);
            start++;
        }
    }

    private static void printMatrixCircle(int[][] arr, int rows, int columns, int start) {

        int endX = columns-1-start;
        int endY = rows-1-start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.print(arr[start][i] + " ");
        }

        // 从上到下打印一行
        // 有可能该圈只有一行，要判断是否需要打印
        if (start < endY){
            // 最上面的数被打印过了
            for (int i = start+1; i <= endY; i++) {
                System.out.print(arr[i][endX] + " ");
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY){
            // 最右面的数被打印过了
            for (int i = endX-1; i >= start; i--) {
                System.out.print(arr[endY][i] + " ");
            }
        }

        // 从下到上打印一行
        if (start < endX && start < endY-1){
            // 最下面的数和最上面的数都被打印过了
            for (int i = endY-1; i >= start+1; i--) {
                System.out.print(arr[i][start] + " ");
            }
        }
    }

    public static void main(String[] args) {

        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        printMatrixClockwisely(arr, 4, 4);
    }
}
