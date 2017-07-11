package com.core.bank;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * 1.����һ��start�������ڲ�����һ���̣߳����ݷ��񴰿ڵ����ֱ�ѭ������������ͬ�ķ�����
 * 2.�������������ֱ�����ֿͻ����з���Ϊ�˹۲�����Ч����Ӧ��ϸ��ӡ�����е�ϸ����Ϣ��
 * 
 * @author bigsw 2017��7��11��
 */
public class ServiceWindow {
	private Logger log = Logger.getLogger("com.core.bank.ServiceWindow");
	private Integer number = 1;
	private CustomerType type = CustomerType.COMMON;

	public void start() {

		//����һ���̳߳أ�������̳߳��У�ֻ����һ���߳�A�����A�����쳣����������������ٴδ���һ���̼߳���ִ��
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				while (true) {
					switch (type) {
					case COMMON:
						CommonService();
						break;
					case QUICK:
						QuickService();
						break;
					case VIP:
						VipService();
						break;
					default:
						break;
					}
				}
			}
		});

	}

	private void VipService() {
		String windowName = number + "��,"+ type + "����";
		log.info(windowName + "��ʼ����....");
		Integer serviceNumber = NumberMachine.getInstance().getVip().fetchNumber();
		if (serviceNumber > 0 && serviceNumber != null) {
			log.info(windowName + "��ʼΪ��" + serviceNumber + "��VIP�ͻ�����");
			int time = Constants.MAX_SEREVICE_TIME - Constants.MIN_SERVICE_TIME;
			int serviceTime=new Random().nextInt(time)+1+Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
				log.info(windowName + "���Ϊ��" + serviceNumber + "��VIP�ͻ������ܹ���ʱ" + serviceTime/1000 + "��");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			log.info(windowName + "û��ȡ��VIP�������ڿ���һ��");       
			CommonService();                 
		}
	}

	private void QuickService() {
		String windowName =  number + "��," + type + "����";
		log.info(windowName + "��ʼ����....");
		Integer serviceNumber = NumberMachine.getInstance().getQuick().fetchNumber();
		if (serviceNumber > 0 && serviceNumber != null) {
			log.info(windowName + "��ʼΪ��" + serviceNumber + "�ſ��ٿͻ�����");
			int time = Constants.MAX_SEREVICE_TIME - Constants.MIN_SERVICE_TIME;
			int serviceTime=new Random().nextInt(time)+1+Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
				log.info(windowName + "���Ϊ��" + serviceNumber + "�ſ��ٿͻ������ܹ���ʱ" + serviceTime/1000 + "��");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			log.info(windowName + "û��ȡ�������������ڿ���һ��");       
			CommonService();                 
		}
	}

	private void CommonService() {
		String windowName =  number + "��," + type + "����";
		log.info(windowName + "��ʼ����....");
		Integer serviceNumber = NumberMachine.getInstance().getCommon().fetchNumber();
		if (serviceNumber > 0 && serviceNumber != null) {
			log.info(windowName + "��ʼΪ��" + serviceNumber + "����ͨ�ͻ�����");
			int time = Constants.MAX_SEREVICE_TIME - Constants.MIN_SERVICE_TIME;
			int serviceTime=new Random().nextInt(time)+1+Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
				log.info(windowName + "���Ϊ��" + serviceNumber + "����ͨ�ͻ������ܹ���ʱ" + serviceTime/1000 + "��");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			log.info(windowName + "û��ȡ����ͨ�������ڿ���һ��");       
	            try {  
	                Thread.sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }                 
		}
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

}
