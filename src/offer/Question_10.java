package offer;

/**
 * 斐波那契数列
 */
public class Question_10 {

    private long fibonacci(int n){

        int[] result = {0,1};
        if (n < 2) {
            return result[n];
        }

        long one = 0;
        long two = 1;
        long res = 0;
        for (int i = 2; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Question_10().fibonacci(4));
    }
}
