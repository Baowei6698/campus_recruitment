package edu.ouc.netease;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Random;

/**
 * 一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不用文件中
 * （不要求输出到每个文件中的数量相同）。要求启动10个线程，两两一组，分为5组。
 * 每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，需要偶数线程每打印10个偶数以后，
 * 就将奇数线程打印10个奇数，如此交替进行。同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，
 * 并在所有线程结束后，在控制台打印”Done”.
 *  
 * @author wqx
 *
 */
public class MultiThreadReadFile {
	public static void main(String[] args) throws IOException{
		/**
		 * 随机生成10000个整数，写入文件input.txt中
		 */
		int num = 10000;
		PrintWriter pw = new PrintWriter(new FileWriter(new File("input.txt")),true);
		Random r = new Random();
		for(int i = 0; i < num; i++){
			pw.write(Math.abs(r.nextInt())%100 + " ");
		}
		pw.flush();pw.close();
		System.out.println("Done");
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
//		String str = br.readLine();
//		System.out.println("str:" + str);
		
	}
}
