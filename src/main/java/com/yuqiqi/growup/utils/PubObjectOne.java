package com.yuqiqi.growup.utils;

/**
 * 生产者1 往队列推送消息
 */
public class PubObjectOne extends Thread {
    private MessageVO messageVO;

    public PubObjectOne(MessageVO messageVO) {
        this.messageVO = messageVO;
    }

    @Override
    public void run() {
        PubSubThreads.arrayBlockingQueue.add(messageVO);
    }
}