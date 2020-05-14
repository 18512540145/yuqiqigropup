package com.yuqiqi.growup.utils.pubsub;

import com.yuqiqi.growup.utils.MessageVO;

/**
 * Created by yuyunbo on 2020/5/13.
 */
public class ConsumerObjectOne implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (PudConThread.hasConsumerTotal.get() >= PudConThread.total) {
                System.out.println("消费者1--消费已达上限停止消费");
                return;
            }
            if (PudConThread.arrayBlockingQueue.size() > 0) {
                /**
                 * 获取最新的一条消息消费
                 */
                MessageVO messageVO = PudConThread.arrayBlockingQueue.poll();
                if (messageVO != null) {
                    System.out.println("消费者1消费消息" + messageVO.toString());
                    PudConThread.hasConsumerTotal.getAndAdd(1);
                }
            }
        }
    }
}
