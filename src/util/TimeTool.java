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
        System.out.println("耗时：" + cost + "毫秒");
        System.out.println("-------------------------------------------");
    }
}
