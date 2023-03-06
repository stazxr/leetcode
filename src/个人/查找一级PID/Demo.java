package 个人.查找一级PID;

import util.TimeTool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在树表格中，查找定级节点列表
 *
 * 1 = 5 6
 * 4 = 2 3
 * 5 = 7 8
 * 6 = 9 10
 *
 * out: [1, 4]
 *
 * @author Thomas
 * @date 2022-08-25
 */
public class Demo {
    public static void main(String[] args) {
        // 0，6，7 => 0
        // key => 父节点; value => 子节点列表
        Map<Long, Set<Long>> data = new HashMap<>();
        Set<Long> tmp1 = new HashSet<>();
        tmp1.add(5L);
        tmp1.add(6L);
        data.put(1L, tmp1);
        Set<Long> tmp2 = new HashSet<>();
        tmp2.add(2L);
        tmp2.add(3L);
        data.put(4L, tmp2);
        Set<Long> tmp3 = new HashSet<>();
        tmp3.add(7L);
        tmp3.add(8L);
        data.put(5L, tmp3);
        Set<Long> tmp4 = new HashSet<>();
        tmp4.add(9L);
        data.put(6L, tmp4);

        TimeTool.check("开始计算", () -> {
            Set<Long> result = calculateFirstFirstPid(data);
            System.out.println("计算结果为：" + result);
        });
    }

    private static Set<Long> calculateFirstFirstPid(Map<Long, Set<Long>> data) {
        Set<Long> result = new HashSet<>();
        Loop: for (Long pid : data.keySet()) {
            for (Set<Long> ids : data.values()) {
                if (ids.contains(pid)) {
                    continue Loop;
                }
            }
            result.add(pid);
        }
        return result;
    }
}
