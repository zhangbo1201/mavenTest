package cn.edu.hhit.service.TreadPoolExecutorTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/229:28
 */
public class ThreadPoolExecutorTest {
    @Test
    public  void test1() throws InterruptedException {
        //测试LinedBlockingDeque队列
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(7,10,0,TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(),new TestThreadFactory());
        for (int i = 0; i < 20; i++) {
            executorService.execute(new TestThread());

        }
        Thread.sleep(300);
        System.out.println(executorService.getCorePoolSize());
        System.out.println(executorService.getMaximumPoolSize());
        System.out.println(executorService.getQueue().size());
        Thread.sleep(10000);
        System.out.println(executorService.getCorePoolSize());
        System.out.println(executorService.getMaximumPoolSize());
        System.out.println(executorService.getQueue().size());


    }
    @Test
    public void test2() throws InterruptedException {
        //测试
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,10,1L,TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(),new TestThreadFactory());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new TestThread());

        }
        Thread.sleep(300);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());
        System.out.println(threadPoolExecutor.getQueue().size());
        Thread.sleep(10000);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());
        System.out.println(threadPoolExecutor.getQueue().size());
    }
}
