package LeetCode;

//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
//
//
//
// 示例 1：
//
//
//输入：s = "hello"
//输出："holle"
//
//
// 示例 2：
//
//
//输入：s = "leetcode"
//输出："leotcede"
//
public class Solution_345 {

    // 对撞指针
    public String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        char temp;
        while (i < j) {
            if (isYuanYin(chars[i]) && isYuanYin(chars[j])) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (!isYuanYin(chars[i]) && isYuanYin(chars[j])) {
                i++;
            } else if (isYuanYin(chars[i]) && !isYuanYin(chars[j])) {
                j--;
            } else {// !isYuanYin(s[i]) && ！isYuanYin(s[j])
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    private static boolean isYuanYin(char element) {
        return element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u'
                || element == 'A' || element == 'E' || element == 'I' || element == 'O' || element == 'U';
    }
}
