package 基本.数组.简单.合并排序的数组;

import util.TimeTool;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 说明: A.length == n + m
 *
 * @date 2022-05-31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo {
    public static void main(String[] args) {
        int[] a = {1,3,6,0,0,0}, b = {2,4,6};
        int m = 3, n = 3;

        TimeTool.check("合并排序的数组", () -> {
            merge(a, m, b, n);
            System.out.println("执行结果为：" + Arrays.toString(a));
        });

        int[] a1 = {0}, b1 = {1};
        int m1 = 0, n1 = 1;
        TimeTool.check("合并排序的数组1", () -> {
            merge(a1, m1, b1, n1);
            System.out.println("执行结果为：" + Arrays.toString(a1));
        });

        int[] a2 = {2,0}, b2 = {1};
        int m2 = 1, n2 = 1;
        TimeTool.check("合并排序的数组2", () -> {
            merge(a2, m2, b2, n2);
            System.out.println("执行结果为：" + Arrays.toString(a2));
        });
    }

    /**
     * 思路：两个数组都是从小到大排序好的，用 b[ 0 -> n ] 跟 a[ m - 1 -> 0 ] 对比
     */
    public static void merge(int[] a, int m, int[] b, int n) {
        // 特殊处理，当 m = 0 时，直接 copy
        if (m == 0) {
            System.arraycopy(b, 0, a, 0, b.length);
            return;
        }

        int ali = m - 1; // a 的最后一个元素下标

        // 遍历 b，逐个将 b 的元素插入 a
        for (int j = 0; j < n; j++) {
            if (b[j] >= a[ali]) {
                // 当前元素大于等于a的最后一个元素，直接后排
                for (int k = ali + 1 ; k < a.length; k++) {
                    a[k] = b[j++];
                }

                // 后排结束，代表后续元素均已插入a，退出循环
                break;
            } else {
                // 当前元素小于a的最后一个元素，遍历a，继续向前查找，直到 b 的当前元素大于等于 a 的元素
                int index = ali + 1; // a 的下一个空元素位置
                do {
                    a[index--] = a[ali];
                    a[ali--] = b[j];
                    // 防止越界，index > 0
                } while (index > 0 && a[index - 1] > a[index]);

                // a 的元素 + 1
                m++;
            }

            // 重置 a 的最后一个元素下标
            ali = m - 1;
        }
    }
}
