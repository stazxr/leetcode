package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task {
        void execute();
    }

    public static void check(String title, Task task) {
        if (task == null) return;
        title = title == null ? "" : ("【" + title + "】");
        System.out.println(title);
        System.out.println("开始：" + format.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束：" + format.format(new Date()));
        long cost = end - begin;
        printCostTime(cost, begin, end);
        System.out.println("-------------------------------------------");
    }

    private static void printCostTime(long cost, long begin, long end) {
        // 转换为 ** 秒 ** 毫秒
        if (cost > 1000) {
            // 大于一秒
            long s = cost / 1000L;
            long ms = cost % 1000L;
            System.out.println("耗时：" + s + "秒" + ms + "毫秒 [" + begin + " - " + end + "]");
        } else {
            // 小于一秒
            System.out.println("耗时：" + cost + "毫秒 [" + begin + " - " + end + "]");
        }
    }
}
