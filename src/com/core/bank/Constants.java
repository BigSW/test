package com.core.bank;

/**
 * 1.��������������MAX_SERVICE_TIME��MIN_SERVICE_TIME��COMMON_CUSTOMER_INTERVAL_TIME��
 * 
 * @author bigsw 2017��7��11��
 */
public class Constants {
	public static int MAX_SEREVICE_TIME = 10000;
	public static int MIN_SERVICE_TIME = 1000;
	/*
	 * ÿ����ͨ���ڷ���һ���ͻ���ƽ��ʱ��Ϊ5�룬һ����4�������Ĵ��ڣ�Ҳ����˵���е�������ͨ���ں�����
	 * ƽ��1.25���ڿ��Է�����һ����ͨ�ͻ����ټ��Ͽ��ٴ��ں�VIP����Ҳ���Է�����ͨ�ͻ������ԣ� 1���Ӳ���һ����ͨ�ͻ��ȽϺ���
	 */
	public static int COMMON_CUSTOMER_INTERVAL_TIME = 1;
}
