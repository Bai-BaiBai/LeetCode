package LeetCode;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class Solution_58 {

    public int lengthOfLastWord(String s) {

        int start = -1;//指向最后一个单词的开始字符下标
        int end = -1;//指向最后一个单词的结束字符下标
        for (int i = s.length()-1; i >= 0 ; i--) {
            if (s.charAt(i) != ' ' && end == -1){
                start = i;
                end = i;
            }else if (s.charAt(i) != ' ' && end != -1){
                start = i;
            }else if (s.charAt(i) == ' ' && end != -1){
                start = i+1;
                break;
            }
        }
        if (end == -1) return 0;
        return end-start+1;
    }
}
