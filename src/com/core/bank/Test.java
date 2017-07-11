package com.core.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		
		//ͨ���̴߳���һ����ʱ����
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate( new Runnable() {
			public void run() {
				Integer waitNumber = NumberMachine.getInstance().getCommon().getNewNumber();
				System.out.println("��" + waitNumber + "����ͨ�ͻ����ڵȴ�����");
			}
		}, 0,Constants.COMMON_CUSTOMER_INTERVAL_TIME,TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate( new Runnable() {
			public void run() {
				Integer waitNumber = NumberMachine.getInstance().getQuick().getNewNumber();
				System.out.println("��" + waitNumber + "�ſ��ٿͻ����ڵȴ�����");
			}
		}, 0,Constants.COMMON_CUSTOMER_INTERVAL_TIME*2,TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(  
                new Runnable(){  
                    public void run(){  
                        Integer serviceNumber = NumberMachine.getInstance().getVip().getNewNumber();  
                        System.out.println("��" + serviceNumber + "��VIP�ͻ����ڵȴ�����");  
                    }  
                },  
                0,  
                Constants.COMMON_CUSTOMER_INTERVAL_TIME * 6,   
                TimeUnit.SECONDS); 
		
		
		//�����ĸ���ͨ�ͻ�����
		for(int i =1;i<5;i++){
			ServiceWindow common = new ServiceWindow();
			common.setNumber(i);
			common.start();
		}
		
		//����1�����ٴ���
		ServiceWindow quick = new ServiceWindow();
		quick.setType(CustomerType.QUICK);
		quick.start();
		
		//����1��VIP����
		ServiceWindow vip = new ServiceWindow();
		vip.setType(CustomerType.VIP);
		vip.start();
	}
}
