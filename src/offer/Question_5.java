package offer;

/**
 * 给定字符数组和数组长度，将字符数组中的空格替换为'a' 'b' 'c'
 */
public class Question_5 {

    public void transfer(char[] arr, int length){

        if (length == 0 || arr == null) return;

        int n = 0; // 实际长度
        int blankNumber = 0; // 空格数
        for (int i = 0; arr[i] != '\0'; i++) {
            n++;
            if (arr[i] == ' '){
                blankNumber++;
            }
        }

        int newLength = n + blankNumber*2;// 转换后的长度
        // 这里默认newLength > length 也就是arr容量默认足够

        while (n >= 0 && newLength > n){
            if (arr[n] != ' '){
                arr[newLength--] = arr[n--];
            }else {
                arr[newLength--] = 'c';
                arr[newLength--] = 'b';
                arr[newLength--] = 'a';
                n--;
            }
        }
    }

    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o',' ','w','o','r','l','d',' ','\0', ' ', ' ',' ', ' '};
        char[] arr2 = {' ', ' ','\0', ' ',' ',' ',' '};
        new Question_5().transfer(arr2, 14);
        for (char c : arr2){
            System.out.print(c);
        }
    }
}
