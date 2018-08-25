package cn.edu.hhit.service.TemplatePattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2520:18
 */
public class Client {
    public static void main(String[] args) {
        HummerModel hummerModel = new Hummer1Model();
        ((Hummer1Model) hummerModel).setAlarm(false);
        hummerModel.run();
    }
}
