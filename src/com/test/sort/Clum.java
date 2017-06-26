package com.test.sort;

/**
 * @author sw
 * @date 2017年6月19日
 */
public class Clum {
	
	public static void main(String[] args) {
		double start =8.00;
		double total = 0.00;
		
	for(int i=1;i<30;i++){
		if(total<=100.00){
			System.out.print("不打折：");
			total=total+start;
			System.out.println("第"+i+"天,"+total);
		}else if(total>100.00&&total<=150.00){
			System.out.print("8折：");
			total=total+start*0.8;
			System.out.println(":第"+i+"天,"+total);
		}else if(total>150.00){
			System.out.print("5折：");
			total=total+start*0.5;
			System.out.println("第"+i+"天,"+total);
		}else{
			total=total+start;
			System.out.println("第"+i+"天,"+total);
		}
	}
	}
}
