package 基本.数组.简单.稀疏数组搜索;

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

    }


    /**
     * 思考，因为数组是排序的，所以可以使用二分法，缩小遍历范围（有序则二分）
     *
     * compareTo方法进行先后对比
     */
    public static int findString(String[] words, String s) {
        int middleIndex = words.length / 2;

        for (int i = middleIndex; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            } else {
                String tmp = words[i];
                if (tmp.equals(s)) {
                    return i;
                } else if (tmp.compareTo(s) > 0) {
                    //
                }

            }


        }

        return -1;
    }
}
