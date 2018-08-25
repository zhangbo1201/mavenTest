package cn.edu.hhit.service.TreadPoolExecutorTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2212:34
 */
public class CountDownLatchTest {
    public static CountDownLatch countDownLatch = new CountDownLatch(7);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 1; i < 8; i++) {
            //开始搜集龙珠
            int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("第"+index+"颗龙珠已经收集到");
                    countDownLatch.countDown();
                }
            };
            executorService.execute(runnable);

        }
        countDownLatch.await();
        System.out.println("s所有龙珠收集完成，召唤圣龙");
    }
}
