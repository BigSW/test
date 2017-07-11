package com.core.bank;

/**
 * 
 * 1.����������Ա�����ֱ�ָ������NumberManager���󣬷ֱ��ʾ��ͨ�����ٺ�VIP�ͻ��ĺ��������
 * ����������Ӧ�ķ���������������NumberManager���� 2.��NumberMachine����Ƴɵ�����
 * 
 * @author bigsw 2017��7��11��
 */
public class NumberMachine {
	private NumberManager common = new NumberManager();
	private NumberManager quick = new NumberManager();
	private NumberManager vip = new NumberManager();

	private static class NumberMachineHolder {
		private static NumberMachine machine = new NumberMachine();
	}

	public static NumberMachine getInstance() {
		return NumberMachineHolder.machine;
	}

	public NumberManager getCommon() {
		return common;
	}

	public void setCommon(NumberManager common) {
		this.common = common;
	}

	public NumberManager getQuick() {
		return quick;
	}

	public void setQuick(NumberManager quick) {
		this.quick = quick;
	}

	public NumberManager getVip() {
		return vip;
	}

	public void setVip(NumberManager vip) {
		this.vip = vip;
	}

}
