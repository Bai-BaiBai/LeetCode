package offer;

/**
 * 旋转最小数字
 */
public class Question_11 {

    private static int findMin(int[] arr){

        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        while (arr[start] >= arr[end]){
            if (end - start == 1){
                mid = end;
                break;
            }

            mid = start + (end-start)/2;

            if (arr[mid] >= arr[start]){
                start = mid;
            } else if (arr[mid] <= arr[end]){
                end = mid;
            }
        }

        return arr[mid];
    }

    public static void main(String[] args) {

        int[] arr = {2,3,4,5,1};
        System.out.println(findMin(arr));
    }
}
