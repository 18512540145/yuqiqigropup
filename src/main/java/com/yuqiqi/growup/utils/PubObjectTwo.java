package com.yuqiqi.growup.utils;

/**
 * 生产者2 往队列推送消息
 */
public class PubObjectTwo extends Thread {
    private MessageVO messageVO;

    public PubObjectTwo(MessageVO messageVO) {
        this.messageVO = messageVO;
    }

    @Override
    public void run() {
        PubSubThreads.arrayBlockingQueue.add(messageVO);
    }
}