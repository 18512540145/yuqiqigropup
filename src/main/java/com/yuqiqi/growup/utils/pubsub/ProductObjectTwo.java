package com.yuqiqi.growup.utils.pubsub;

import com.yuqiqi.growup.utils.MessageVO;

import java.util.UUID;

/**
 * Created by yuyunbo on 2020/5/13.
 */
public class ProductObjectTwo implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (PudConThread.hasProductTotal.get() >= PudConThread.total) {
                System.out.println("产品已达上限，停止生产");
                return;
            }
            MessageVO messageVO = new MessageVO(PudConThread.hasProductTotal.getAndAdd(1), UUID.randomUUID().toString(), "ProductObjectTwo---this is pubsub test");
            try {
                PudConThread.arrayBlockingQueue.put(messageVO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
