package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 
题目描述

有一个单色屏幕储存在一维数组中，其中数组的每个元素代表连续的8位的像素的值，请实现一个函数，将第x到第y个像素涂上颜色
(像素标号从零开始)，并尝试尽量使用最快的办法。

给定表示屏幕的数组screen(数组中的每个元素代表连续的8个像素，且从左至右的像素分别对应元素的二进制的从低到高位)，
以及int x,int y，意义如题意所述，保证输入数据合法。请返回涂色后的新的屏幕数组。
测试样例：

[0,0,0,0,0,0],0,47

返回：[255,255,255,255,255,255]


 * @author wqx
 *
 */
public class _5_8_RenderPixel {
	
	/**
	 * 通过给定的像素坐标，确定该像素在数组中的位置
	 * 
	 * @param screen
	 * @param x
	 * @param y
	 * @return
	 */
    public static int[] renderPixel(int[] screen, int x, int y) {
    	
    	for(int i = x; i <= y; i++){
    		int posOfArr = i / 8;
    		int posOfBit = i % 8;
    		
    		int elem = screen[posOfArr];
    		
    		int mask = 0x00000001;
    		for(int j = 0; j < posOfBit; j++){
    			mask <<= 1;
    		}
    		screen[posOfArr] = elem | mask;
    	}
    	return screen;
    }
    public static void main(String args[]){
    	int [] screen = {0,0,0,0,0,0};
    	System.out.println(Arrays.toString(renderPixel(screen,0,47)));
    	
    	
    }
}
