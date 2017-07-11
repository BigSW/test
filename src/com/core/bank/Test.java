package com.core.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		
		//通过线程创建一个定时任务
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate( new Runnable() {
			public void run() {
				Integer waitNumber = NumberMachine.getInstance().getCommon().getNewNumber();
				System.out.println("第" + waitNumber + "号普通客户正在等待服务！");
			}
		}, 0,Constants.COMMON_CUSTOMER_INTERVAL_TIME,TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate( new Runnable() {
			public void run() {
				Integer waitNumber = NumberMachine.getInstance().getQuick().getNewNumber();
				System.out.println("第" + waitNumber + "号快速客户正在等待服务！");
			}
		}, 0,Constants.COMMON_CUSTOMER_INTERVAL_TIME*2,TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(  
                new Runnable(){  
                    public void run(){  
                        Integer serviceNumber = NumberMachine.getInstance().getVip().getNewNumber();  
                        System.out.println("第" + serviceNumber + "号VIP客户正在等待服务！");  
                    }  
                },  
                0,  
                Constants.COMMON_CUSTOMER_INTERVAL_TIME * 6,   
                TimeUnit.SECONDS); 
		
		
		//创建四个普通客户窗口
		for(int i =1;i<5;i++){
			ServiceWindow common = new ServiceWindow();
			common.setNumber(i);
			common.start();
		}
		
		//创建1个快速窗口
		ServiceWindow quick = new ServiceWindow();
		quick.setType(CustomerType.QUICK);
		quick.start();
		
		//创建1个VIP窗口
		ServiceWindow vip = new ServiceWindow();
		vip.setType(CustomerType.VIP);
		vip.start();
	}
}
