package edu.ouc.netease;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Random;

/**
 * һ���ļ�����10000��������Javaʵ��һ�����̳߳������10000���������5�������ļ���
 * ����Ҫ�������ÿ���ļ��е�������ͬ����Ҫ������10���̣߳�����һ�飬��Ϊ5�顣
 * ÿ�������̷ֱ߳��ļ��е�������ż������������Ӧ��һ���ļ��У���Ҫż���߳�ÿ��ӡ10��ż���Ժ�
 * �ͽ������̴߳�ӡ10����������˽�����С�ͬʱ��Ҫ��¼������ȣ�ÿ���1000�������ڿ���̨�д�ӡ��ǰ���������
 * ���������߳̽������ڿ���̨��ӡ��Done��.
 *  
 * @author wqx
 *
 */
public class MultiThreadReadFile {
	public static void main(String[] args) throws IOException{
		/**
		 * �������10000��������д���ļ�input.txt��
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
