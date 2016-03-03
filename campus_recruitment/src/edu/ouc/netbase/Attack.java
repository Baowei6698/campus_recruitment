package edu.ouc.netbase;

import java.util.Scanner;

public class Attack {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int x1,y1,x2,y2,x3,y3,x0,y0;
		while(in.hasNext()){
			int R = in.nextInt();
			x1 = in.nextInt();y1 = in.nextInt();
			x2 = in.nextInt();y2 = in.nextInt();
			x3 = in.nextInt();y3 = in.nextInt();
			x0 = in.nextInt();y0 = in.nextInt();
			int harmV = 0;
			boolean hit1 = isHit(x1,y1,x0,y0,R);
			if(hit1)
				harmV++;
			hit1 = isHit(x2,y2,x0,y0,R);
			if(hit1)
				harmV++;
			hit1 = isHit(x3,y3,x0,y0,R);
			if(hit1)
				harmV++;
			System.out.println(harmV);
		}
	}
	public static boolean isHit(int x1,int y1,int x2,int y2,int R){
		double dis = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		if(dis > R*1.0){
			return false;
		}else{
			return true;
		}
	}
}
