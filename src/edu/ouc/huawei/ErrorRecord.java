package edu.ouc.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
��Ŀ����
����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš�
����:
1.��¼���8�������¼������ͬ�Ĵ����¼(���ļ����ƺ��к���ȫƥ��)ֻ��¼һ��������������ӣ�
(�ļ����ڵ�Ŀ¼��ͬ���ļ������к���ͬҲҪ�ϲ�)
2.����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���
(����ļ�����ͬ����ֻ���ļ����ĺ�16���ַ����к���ͬ��Ҳ��Ҫ�ϲ�)
3.������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·��

��������:

һ�л�����ַ�����ÿ�а�����·���ļ����ƣ��кţ��Կո������

    �ļ�·��Ϊwindows��ʽ

    �磺E:\V1R2\product\fpgadrive.c 1325



�������:

�����еļ�¼ͳ�Ʋ�������������ʽ���ļ�������������Ŀ��һ���ո��������: fpgadrive.c 1325 1 

    ���������Ŀ�Ӷൽ��������Ŀ��ͬ������£����������һ�γ���˳������

    �������8����¼����ֻ���ǰ8����¼.

    ����ļ����ĳ��ȳ���16���ַ�����ֻ�����16���ַ�


��������:

E:\V1R2\product\fpgadrive.c 1325


�������:

fpgadrive.c 1325 1


 */
public class ErrorRecord {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		List<String> names = new ArrayList<String>();
		List<Integer> lines = new ArrayList<Integer>();
		List<Integer> times = new ArrayList<Integer>();
		
		while(sc.hasNext()){
			String path = sc.next();
			int line = sc.nextInt();
			String fileName = getFileName(path);
			handle(names,lines,times,fileName,line);
		}
		for(int i = 0; i < names.size(); i++){
			for(int j = i+1; j < names.size(); j++){
				if(times.get(i) < times.get(j)){
					swap(names,i,j);
					swap(lines,i,j);
					swap(times,i,j);
				}
			}
		}
		for(int i = 0; i < names.size(); i++){
			System.out.println(names.get(i) + "," + lines.get(i) + "," + times.get(i));
		}
	}
	public static void swap(List list,int a,int b){
		Object tmp = list.get(a);
		list.set(a,list.get(b));
		list.set(b, tmp);
	}
	public static void handle(List<String>names,List<Integer>lines,List<Integer>times,String fileName,int line){
		int index = -1;
		for(int i = 0; i < names.size(); i++){
			if(names.get(i).equals(fileName)){
				index = i;break;
			}
		}
		if(index >= 0 && lines.get(index) == line){
			times.set(index,times.get(index)+1);
		}else{
			names.add(fileName);
			lines.add(line);
			times.add(1);
		}
	}
	public static String getFileName(String path){
		if(path.lastIndexOf("\\") != -1){
			return path.substring(path.lastIndexOf("\\")+1);
		}else{
			return path;
		}
	}
}
