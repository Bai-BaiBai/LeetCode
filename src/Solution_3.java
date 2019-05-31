import java.util.HashMap;

/**
 * 3.无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution_3 {

    /**第一种解法：
     * map存储当前的无重复字符子串
     * 遍历时如果map中不存在该元素，就将它和它的下标存入到map中
     * 如果存在该元素，说明有重复元素，暂存此时的最大长度(也就是map.size和原先的maxSize比较)
     * 并且拿出重复元素的下标赋值给 i 完成回溯，清空map，进入下次循环时，由于先执行i++,所以是从重复元素的后一个元素开始执行
     */
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int length = 0;//length变量可以用map.size()代替
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                maxLength = Math.max(maxLength, length);//取当前存储的最大长度和当前子串的长度 中的最大值
                i = map.get(c);//回溯到重复的那个元素的下标，下次循环时 i++ 会从它的后一个元素开始执行
                map.clear();
                length = 0;
            }
            else {
                map.put(c, i);
                length++;
            }
        }
        maxLength = Math.max(maxLength, length);

        return maxLength;

    }

    /**
     * 第二种解法
     *
     */
    public int solution2(String s){
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

    public static void main(String[] args) {
        new Solution_3().solution2("abcab");

    }
}
