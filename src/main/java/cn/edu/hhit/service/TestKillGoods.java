package cn.edu.hhit.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangbo
 * @Package cn.edu.hhit.service
 * @Description: ${todo}
 * @date 2018/8/26 16:09
 */
public class TestKillGoods {
    public static void main(String[] args) {
        KillGoods killGoods = new KillGoods();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 500; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    killGoods.seckill();
                }
            });
        }
    }
}
