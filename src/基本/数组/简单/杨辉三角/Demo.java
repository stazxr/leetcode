package 基本.数组.简单.杨辉三角;

import util.TimeTool;

import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo {
    public static void main(String[] args) {
        int numRows = 5;
        TimeTool.check("按摩师", () -> {
            List<List<Integer>> result = generate(numRows);
            System.out.println("执行结果为：" + result);
        });
    }

    // 1 1+3 3+3 3+1 1
    public static List<List<Integer>> generate(int numRows) {
        for (int i = 0; i < numRows; i++) {

        }

        return null;
    }
}
