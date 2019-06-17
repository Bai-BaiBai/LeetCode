/**
 * 28. 实现strStr()
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回-1。
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 */
public class Solution_28 {

    // 三个指针
    public int strStr(String haystack, String needle) {

        if (needle.equals("") || needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        int i = 0;
        for (int j = 0; j < haystack.length(); j++, i=j){
            if (haystack.charAt(j) == needle.charAt(0)){
                boolean flag = true;
                for (int k = 1; k < needle.length(); k++) {
                    i++;
                    if (i >= haystack.length() || haystack.charAt(i) != needle.charAt(k)){
                        flag = false;
                        break;
                    }
                }
                if (flag) return j;
            }
        }
        return -1;
    }
}
