package 基本.数组.简单.按摩师;

import util.Assert;
import util.TimeTool;

import java.util.HashMap;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 *  给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 *
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * @date 2022-06-01
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        TimeTool.check("按摩师", () -> {
            int result = massage(nums);
            System.out.println("执行结果为：" + result);
             Assert.test(result == 4173);
        });

        int[] nums2 = {1,2,3,1};
        TimeTool.check("按摩师2", () -> {
            int result = massage(nums2);
            System.out.println("执行结果为：" + result);
        });
    }

    // 思路：https://leetcode.cn/problems/the-masseuse-lcci/solution/an-mo-shi-bu-bu-shen-ru-jue-dui-neng-dong-cong-zui/
    // 感谢大佬教学!!!
    public static int massage(int[] nums) {
        // 用于存储计算过的节点
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = diGui2(nums, 0, nums.length - 1, map);
        System.out.println("map: " + map);
        return result;
    }

    // 暴力递归 49秒965毫秒
    private static int diGui(int[] nums, int start, int end) {
        if (start > end) {
            // 递归出口
            return 0;
        }

        // 选择 i, 在区间 [i + 2, n - 1] 中寻找最大值
        int pick = nums[start] + diGui(nums, start + 2, end);

        // 不选择 i, 在区间 [i + 1, n - 1] 中寻找最大值
        int notPick = diGui(nums, start + 1, end);

        // 返回较大者
        return Math.max(pick, notPick);
    }

    // 记忆递归（备忘录）
    private static int diGui2(int[] nums, int start, int end, HashMap<Integer, Integer> map) {
        if (start > end) {
            // 递归出口
            return 0;
        }

        if (map.containsKey(end - start)) {
            // 如果计算过，直接返回
            return map.get(end - start);
        }

        // 选择 i, 在区间 [i + 2, n - 1] 中寻找最大值
        int pick = nums[start] + diGui2(nums, start + 2, end, map);
        map.put(end - start, pick);

        // 不选择 i, 在区间 [i + 1, n - 1] 中寻找最大值
        int notPick = diGui2(nums, start + 1, end, map);
        map.put(end - start - 1, notPick);

        // 返回较大者
        return Math.max(pick, notPick);
    }
}
