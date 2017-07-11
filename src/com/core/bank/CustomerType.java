package com.core.bank;

/**
  1.系统中有三种类型的客户，所以用定义一个枚举类，其中定义三个成员分别表示三种类型的客户。
  2.重写toString方法，返回类型的中文名称。这是在后面编码时重构出来的。
 * @author bigsw
 *2017年7月11日
 */
public enum CustomerType {
	COMMON, QUICK, VIP;
	public String getName() {
		String name = null;
		switch (this) {
		case COMMON:
			name = "普通用户";
			break;
		case QUICK:
			name = "快速用户";
			break;
		case VIP:
			name = "vip用户";
			break;
		default:
			break;
		}
		return name;
	}
}
