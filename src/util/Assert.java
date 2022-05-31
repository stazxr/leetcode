package util;

public class Assert {
    public static void test(boolean value) {
        try {
            if (!value) {
                throw new Exception("啊，测试不通过！！！");
            }
            System.out.println("恭喜，测试通过！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
