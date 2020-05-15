package com.yuqiqi.growup.utils.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * <p>[描述信息：线程池异常处理类]</p>
 * 线程提交任务失败，睡眠1s之后提交
 * @author 虞云波 - yuyunbo@lawxp.com
 * @version 1.0 Created on 2016-4-7 上午10:02:43
 */
public class ThreadRejectedExecutionHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.err.println("线程池已满！！！ Waiting for a second !!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(r);
	}

}
