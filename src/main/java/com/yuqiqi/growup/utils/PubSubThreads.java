package com.yuqiqi.growup.utils;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuyunbo on 2020/5/12.
 */
public class PubSubThreads {
    public static final ArrayBlockingQueue<MessageVO> arrayBlockingQueue = new ArrayBlockingQueue<>(1024);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        /**
         * 先启动监听,消费者
         */
        SubObjectOne subObjectOne = new SubObjectOne();
        subObjectOne.start();
        SubObjectTwo subObjectTwo = new SubObjectTwo();
        subObjectTwo.start();
        for (int i = 0; i <= 100; i++) {
            MessageVO messageVO = new MessageVO(i, UUID.randomUUID().toString(), "this is test");
            if (i % 2 != 0) {
                //单数用发布者1
                PubObjectOne pubObjectOne = new PubObjectOne(messageVO);
                executorService.submit(pubObjectOne);
            } else {
                //双数用发布者2
                PubObjectTwo pubObjectTwo = new PubObjectTwo(messageVO);
                executorService.submit(pubObjectTwo);
            }
            /**
             * 每隔20 步长 休息5秒
             */
            if (i != 0 && i % 20 == 0) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
