package com.core.bank;

/**
  1.ϵͳ�����������͵Ŀͻ��������ö���һ��ö���࣬���ж���������Ա�ֱ��ʾ�������͵Ŀͻ���
  2.��дtoString�������������͵��������ơ������ں������ʱ�ع������ġ�
 * @author bigsw
 *2017��7��11��
 */
public enum CustomerType {
	COMMON, QUICK, VIP;
	public String getName() {
		String name = null;
		switch (this) {
		case COMMON:
			name = "��ͨ�û�";
			break;
		case QUICK:
			name = "�����û�";
			break;
		case VIP:
			name = "vip�û�";
			break;
		default:
			break;
		}
		return name;
	}
}
