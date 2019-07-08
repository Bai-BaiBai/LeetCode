package offer;

public class Question_4 {

    public boolean find(int[][] arr, int rows, int columns, int number){

        if (rows <= 0 || columns <= 0) return false;

        int i = 0;      // 数组中当前位置的行
        int j = columns-1;// 数组中当前位置的列

        while (i < rows && j >= 0){
            if (arr[i][j] == number) return true;

            if (arr[i][j] > number) {
                j--;
            }
            // arr[i][j] < number
            else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(new Question_4().find(arr, 4, 4, 16));
    }
}
