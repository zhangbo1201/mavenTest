package cn.edu.hhit.service.TreadPoolExecutorTest;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/229:29
 */
public class TestThread implements  Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"Run"+System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
