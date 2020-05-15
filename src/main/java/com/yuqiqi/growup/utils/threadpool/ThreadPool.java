package com.yuqiqi.growup.utils.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>[描述信息：线程池类]</p>
 *
 * @author 虞云波 - yuyunbo@lawxp.com
 * @version 1.0 Created on 2016-4-7 上午10:01:59
 */
public class ThreadPool extends ThreadPoolExecutor {
	
	public ThreadPool(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		//System.out.println("Perform beforeExecute() logic");
	}
	
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if(t != null)
        {
            System.err.println("Perform exception handler logic");
        }
        //System.out.println("Perform afterExecute() logic");
	}
	
}  
	

