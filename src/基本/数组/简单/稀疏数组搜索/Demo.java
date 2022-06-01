package 基本.数组.简单.稀疏数组搜索;

import util.TimeTool;

import java.util.Arrays;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 *
 * @date 2022-05-31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo {
    public static void main(String[] args) {
        String[] words = {"nd", "ycYAoTJBUjonLxlLBy"};
        String s = "EOqIKUuWGxayVypXH";
        TimeTool.check("稀疏数组搜索", () -> {
            int string = findString(words, s);
            System.out.println("执行结果为：" + string);
        });
    }


    /**
     * 思考，因为数组是排序的，所以可以使用二分法，缩小遍历范围（有序则二分）
     *
     * compareTo方法进行先后对比
     * 执行用时： 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.7 MB, 在所有 Java 提交中击败了 5.13% 的用户
     */
    public static int findString(String[] words, String s) {
        // 判空
        if (words == null || words.length == 0) {
            return -1;
        }

        // 先定义查找范围，元素可能存在的范围 [startIndex, endIndex]
        int startIndex = 0;
        int endIndex = words.length - 1;
        int middleIndex = startIndex + (endIndex - startIndex) / 2; // 查找范围的中间位置

        do {
            // 永远是往前查找，所以middleIndex必须加一，否则查找不到最后一个元素
            for (int i = middleIndex; i >= startIndex; i--) {
                if ("".equals(words[i])) {
                    if (i == startIndex) {
                        // 这个区域都为空，查找后区域
                        startIndex = middleIndex;
                        middleIndex = startIndex + (endIndex - startIndex) / 2;
                        break;
                    } else {
                        continue;
                    }
                }

                if (words[i].compareTo(s) == 0) {
                    return i;
                } else if (words[i].compareTo(s) > 0) {
                    // 当前单词在查找单词的后面，所以单词可能存在前半部分，前半部分不加一
                    endIndex = i;
                    middleIndex = startIndex + (endIndex - startIndex) / 2;
                } else {
                    // 当前单词在查找单词的前面，所以单词可能存在后半部分，元素可能存在的范围变为了 [middleIndex, endIndex]
                    startIndex = middleIndex;
                    middleIndex = startIndex + (endIndex - startIndex) / 2;
                }
                break;
            }

            // 边界
            if (endIndex - 1 == startIndex) {
                if (words[startIndex].equals(s)) {
                    return startIndex;
                } else if (words[endIndex].equals(s)) {
                    return endIndex;
                } else {
                    return -1;
                }
            }
        } while (endIndex != startIndex);

        return -1;
    }
}
