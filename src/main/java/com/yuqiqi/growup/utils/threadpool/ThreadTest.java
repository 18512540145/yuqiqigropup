/**
 * 文件名：ThreadTest.java
 *
 * 创建人：虞云波 - yuyunbo@lawxp.com
 *
 * 创建时间：2016-7-14 下午02:03:32
 *
 * 版权所有：南京汇法正信信息科技有限公司
 */
package com.yuqiqi.growup.utils.threadpool;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 虞云波 - yuyunbo@lawxp.com
 * @version 1.0 Created on 2016-7-14 下午02:03:32
 */
public class ThreadTest {

	private static ReadWriteLock lock = new ReentrantReadWriteLock();  
	private static Person person = new Person("David Beckham", true);  
	
	/**
	 * 
	 * <p>线程互斥所测试</p>
	 * 
	 * @param args
	 * @author: 虞云波 - yuyunbo@lawxp.com
	 * @date: Created on 2017-3-3 下午01:11:12
	 */
	public static void main(String[] args) {  
        new Thread() {  
            public void run() {  
                while(true) {  
                    try {
                        lock.readLock().lock();
                        System.out.print("name = " + person.getName());  
                        System.out.println(", isMan = " + person.isMan());  
                    } finally {
                       lock.readLock().unlock();
                    }
                }  
            };  
        }.start();  
        
        new Thread() {  
            public void run() {  
                boolean state = true;  
                while(true) {  
                    try {  
                        lock.writeLock().lock();  
                        if (state) {  
                            person.setName("Lady GaGa");  
                            person.setMan(false);  
                            state = false;  
                        } else {  
                            person.setName("David Beckham");  
                            person.setMan(true);  
                            state = true;  
                        }  
                          
                    } finally {  
                        lock.writeLock().unlock();  
                    }  
                }  
            };  
        }.start();  
    }  
} 
	
	class Person {  
	    private String name;  
	    private boolean isMan;  
	  
	    public Person(String name, boolean isMan) {  
	        this.name = name;  
	        this.isMan = isMan;  
	    }  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    public boolean isMan() {  
	        return isMan;  
	    }  
	  
	    public void setMan(boolean isMan) {  
	        this.isMan = isMan;  
	    } 
}
