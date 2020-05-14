package com.yuqiqi.growup.utils.pubsub;

import com.yuqiqi.growup.utils.MessageVO;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuyunbo on 2020/5/13.
 */
public class PudConThread {
    public static int total = 100;
    public static volatile AtomicInteger hasProductTotal = new AtomicInteger(0);
    public static volatile AtomicInteger hasConsumerTotal = new AtomicInteger(0);
    public static final ArrayBlockingQueue<MessageVO> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        Thread productThread1 = new Thread(new ProductObjectOne(), "P-1");
        Thread productThread2 = new Thread(new ProductObjectTwo(), "P-2");
        Thread consumerThread1 = new Thread(new ConsumerObjectOne(), "C-1");
        Thread consumerThread2 = new Thread(new ConsumerObjectTwo(), "C-2");
        consumerThread1.start();
        consumerThread2.start();
        productThread1.start();
        productThread2.start();
        try {
            consumerThread1.join();
            consumerThread2.join();
            productThread1.join();
            productThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
