package com.yuqiqi.growup.utils.threadpool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;





/**
 * 
 * <p>[描述信息：线程池工厂]</p>
 *
 * @author 虞云波 - yuyunbo@lawxp.com
 * @version 1.0 Created on 2016-4-7 上午10:02:20
 */
public class ThreadPoolFactory {
	
	
	private final static int CoreThreadCounts = 10;//池中所保存的线程数，包括空闲线程。
	private final static int maxThreadCounts = 100;//线程池维护线程的最大数量
	private final static long spanTime = 50L;  //当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间
	private final static int queueLength = 10000; //队列长度
	
	private ThreadPool  pool;  //线程池
	
	private static ThreadPoolFactory factory;
	
	/**
	 * 
	 * <p>单例模式的有界线程池</p>
	 * 
	 * @return
	 * @author: 虞云波 - yuyunbo@lawxp.com
	 * @date: Created on 2017-3-3 下午01:05:37
	 */
	public static ThreadPoolFactory getInstance(){
		if( factory == null ){
			synchronized (ThreadPoolFactory.class) {
				if(factory == null){
					factory = new ThreadPoolFactory();
					factory.initThreadPool();
				}
			}
		}
		return factory;
    }
	
	
	/**
	 * 
	 * <p>初始化线程池</p>
	 * 
	 * @author: 虞云波 - yuyunbo@lawxp.com
	 * @date: Created on 2017-3-3 下午01:08:54
	 */
	public void initThreadPool(){
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(queueLength);
        pool = new ThreadPool(CoreThreadCounts, maxThreadCounts, spanTime, TimeUnit.SECONDS, blockingQueue);
        pool.setRejectedExecutionHandler(new ThreadRejectedExecutionHandler());
	}
	
	
	/**
	 * 
	 * <p>新增线程池任务</p>
	 * 
	 * @param run
	 * @author: 虞云波 - yuyunbo@lawxp.com
	 * @date: Created on 2017-3-3 下午01:09:06
	 */
    public synchronized void addTask(Runnable run){
    	
        pool.execute(run);
    }
     
   /**
    * 
    * <p>新增线程池任务</p>
    * 
    * @param runs
    * @author: 虞云波 - yuyunbo@lawxp.com
    * @date: Created on 2017-3-3 下午01:09:20
    */
    public synchronized void addTask(List<Runnable> runs){
        if(runs != null){
            for(Runnable r:runs){
                this.addTask(r);
            }
        }
    }
     
  
    /**
     * 
     * <p>关闭线程池</p>
     * 
     * @author: 虞云波 - yuyunbo@lawxp.com
     * @date: Created on 2017-3-3 下午01:09:44
     */
    public void closePool(){
        pool.shutdown();
    }
    
    /**
     * 
     * <p>打开线程池</p>
     * 
     * @author: 虞云波 - yuyunbo@lawxp.com
     * @date: Created on 2017-3-3 下午01:09:55
     */
    public void openPool(){
    	initThreadPool();
    }
    
    /**
     * 
     * <p>判断线程池中所有任务是否完成</p>
     * 
     * @return
     * @author: 虞云波 - yuyunbo@lawxp.com
     * @date: Created on 2017-3-3 下午01:10:05
     */
    public boolean getTerminatedStatus(){
    	return pool.isTerminated();
    }


	public  ThreadPool getPool() {
		return pool;
	}

    
}
