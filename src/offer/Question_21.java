package offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Question_21 {

    private static void reorder(int[] arr){

        if (arr.length < 1) return;

        int i = 0;
        int j = arr.length-1;
        while (i < j){
            while ( i < j && (arr[i] & 0x1) == 1) i++;
            while ( i < j && (arr[j] & 0x1) == 0) j--;

            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,0,0,0,0,0,2};

        reorder(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
