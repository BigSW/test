package com.core.bank;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * 1.定义一个start方法，内部启动一个线程，根据服务窗口的类别分别循环调用三个不同的方法。
 * 2.定义三个方法分别对三种客户进行服务，为了观察运行效果，应详细打印出其中的细节信息。
 * 
 * @author bigsw 2017年7月11日
 */
public class ServiceWindow {
	private Logger log = Logger.getLogger("com.core.bank.ServiceWindow");
	private Integer number = 1;
	private CustomerType type = CustomerType.COMMON;

	public void start() {

		//启动一个线程池，在这个线程池中，只存在一个线程A，如果A出现异常或正常结束，则会再次创建一个线程继续执行
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
		String windowName = number + "号,"+ type + "窗口";
		log.info(windowName + "开始服务....");
		Integer serviceNumber = NumberMachine.getInstance().getVip().fetchNumber();
		if (serviceNumber > 0 && serviceNumber != null) {
			log.info(windowName + "开始为第" + serviceNumber + "号VIP客户服务");
			int time = Constants.MAX_SEREVICE_TIME - Constants.MIN_SERVICE_TIME;
			int serviceTime=new Random().nextInt(time)+1+Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
				log.info(windowName + "完成为第" + serviceNumber + "号VIP客户服务，总共耗时" + serviceTime/1000 + "秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			log.info(windowName + "没有取到VIP任务，正在空闲一秒");       
			CommonService();                 
		}
	}

	private void QuickService() {
		String windowName =  number + "号," + type + "窗口";
		log.info(windowName + "开始服务....");
		Integer serviceNumber = NumberMachine.getInstance().getQuick().fetchNumber();
		if (serviceNumber > 0 && serviceNumber != null) {
			log.info(windowName + "开始为第" + serviceNumber + "号快速客户服务");
			int time = Constants.MAX_SEREVICE_TIME - Constants.MIN_SERVICE_TIME;
			int serviceTime=new Random().nextInt(time)+1+Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
				log.info(windowName + "完成为第" + serviceNumber + "号快速客户服务，总共耗时" + serviceTime/1000 + "秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			log.info(windowName + "没有取到快速任务，正在空闲一秒");       
			CommonService();                 
		}
	}

	private void CommonService() {
		String windowName =  number + "号," + type + "窗口";
		log.info(windowName + "开始服务....");
		Integer serviceNumber = NumberMachine.getInstance().getCommon().fetchNumber();
		if (serviceNumber > 0 && serviceNumber != null) {
			log.info(windowName + "开始为第" + serviceNumber + "号普通客户服务");
			int time = Constants.MAX_SEREVICE_TIME - Constants.MIN_SERVICE_TIME;
			int serviceTime=new Random().nextInt(time)+1+Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
				log.info(windowName + "完成为第" + serviceNumber + "号普通客户服务，总共耗时" + serviceTime/1000 + "秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			log.info(windowName + "没有取到普通任务，正在空闲一秒");       
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
