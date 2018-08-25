package cn.edu.hhit.service.TreadPoolExecutorTest;

import java.util.concurrent.ThreadFactory;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/229:31
 */
public class TestThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("张波"+System.currentTimeMillis());
        return thread;
    }
}
