package com.yuqiqi.growup.utils;

/**
 * 消息消费者 1
 */
public class SubObjectOne extends Thread {
    @Override
    public void run() {
        while (true) {
            if (PubSubThreads.arrayBlockingQueue.size() > 0) {
                /**
                 * 获取最新的一条消息消费
                 */
                try {
                    MessageVO messageVO = PubSubThreads.arrayBlockingQueue.take();
                    System.out.println("消费者1消费消息" + messageVO.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                MessageVO messageVO = PubSubThreads.arrayBlockingQueue.poll();
//                if (messageVO != null) {
//                    System.out.println("消费者1消费消息" + messageVO.toString());
//                }
            }
        }
    }
}