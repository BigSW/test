package com.core.bank;

/**
 * 
 * 1.定义三个成员变量分别指向三个NumberManager对象，分别表示普通、快速和VIP客户的号码管理器
 * 定义三个对应的方法来返回这三个NumberManager对象。 2.将NumberMachine类设计成单例。
 * 
 * @author bigsw 2017年7月11日
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
