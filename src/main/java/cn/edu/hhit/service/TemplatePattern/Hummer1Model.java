package cn.edu.hhit.service.TemplatePattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2520:15
 */
public class Hummer1Model extends HummerModel {
    private boolean isAlarm = true;
    //H1型号的悍马车鸣笛
    public void alarm() {
        System.out.println("悍马H1鸣笛...");
    }
    //引擎轰鸣声
    public void engineBoom() {
        System.out.println("悍马H1引擎声音是这样在...");
    }
    //汽车发动
    public void start() {
        System.out.println("悍马H1发动...");
    }
    //停车
    public void stop() {
        System.out.println("悍马H1停车...");
    }

    @Override
    protected boolean isAlarm() {
        return this.isAlarm;
    }
    public void setAlarm(boolean isAlarm){
        this.isAlarm = isAlarm;
    }
}
