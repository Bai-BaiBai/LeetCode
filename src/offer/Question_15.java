package offer;

/**
 * 二进制中1的个数
 * 给定一个整数，输出该数二进制表示中1的个数
 */
public class Question_15 {

    public int numberOf1(int n){

        int count = 0;
        while (n > 0){
            count++;
            n = (n-1) & n;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Question_15().numberOf1(15));
    }
}
