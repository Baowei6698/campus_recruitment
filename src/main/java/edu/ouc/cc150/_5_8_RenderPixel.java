package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 
��Ŀ����

��һ����ɫ��Ļ������һά�����У����������ÿ��Ԫ�ش���������8λ�����ص�ֵ����ʵ��һ������������x����y������Ϳ����ɫ
(���ر�Ŵ��㿪ʼ)�������Ծ���ʹ�����İ취��

������ʾ��Ļ������screen(�����е�ÿ��Ԫ�ش���������8�����أ��Ҵ������ҵ����طֱ��ӦԪ�صĶ����ƵĴӵ͵���λ)��
�Լ�int x,int y��������������������֤�������ݺϷ����뷵��Ϳɫ����µ���Ļ���顣
����������

[0,0,0,0,0,0],0,47

���أ�[255,255,255,255,255,255]


 * @author wqx
 *
 */
public class _5_8_RenderPixel {
	
	/**
	 * ͨ���������������꣬ȷ���������������е�λ��
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
