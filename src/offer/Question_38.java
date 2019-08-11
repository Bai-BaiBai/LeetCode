package offer;

/**
 * 字符串的排列
 */
public class Question_38 {

    private static void question(char[] str){

        if (str.length < 1) return;

        question(str, 0);
    }

    private static void question(char[] str, int beginIndex) {

        if (beginIndex >= str.length) {
            System.out.println(str[beginIndex]);
        }
        else {
            for (char c = str[beginIndex]; c != '\0'; beginIndex++) {

                char temp = c;
                c = str[beginIndex];
                str[beginIndex] = temp;

                question(str, beginIndex+1);
                temp = c;
                c = str[beginIndex];
                str[beginIndex] = c;
            }
        }
    }
}
