package offer;

/**
 * 数字在排序数组中出现的次数
 */
public class Question_53 {

    int getNumberOfK(int[] arr, int length, int k){

        int number = 0;
        if (length > 0){
            int first = getFirstK(arr, length, k, 0, length-1);
            int last = getLastK(arr, length, k, 0, length-1);

            if (first > -1 && last > -1){
                number = last-first + 1;
            }
        }

        return number;
    }

    private int getFirstK(int[] arr, int length, int k, int start, int end) {

        if (start > end) return -1;

        int midIndex = (start + end)/2;
        int midData = arr[midIndex];

        if (midData > k){
            end = midIndex-1;
        }else if (midData < k){
            start = midIndex +1;
        }else {
            if ((midIndex > 0 && arr[midIndex-1] != k) || midIndex == 0){
                return midIndex;
            }else {
                end = midIndex-1;
            }
        }

        return getFirstK(arr,length,k,start,end);
    }

    private int getLastK(int[] arr, int length, int k, int start, int end) {

        if (start < end) return -1;

        int midIndex = (start + end)/2;
        int midData = arr[midIndex];

        if (midData > k){
            end = midIndex-1;
        }else if (midData < k){
            start = midIndex+1;
        }else {
            if ((midIndex < length-1 && arr[midIndex+1] != k) || midIndex == length-1){
                return midIndex;
            }else {
                start = midIndex+1;
            }
        }

        return getLastK(arr, length, k, start, end);
    }

}
