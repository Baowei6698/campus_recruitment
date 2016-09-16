package edu.ouc.cc150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �ַ����任
 * 
 * ��Ŀ����

����һ���ֵ䣬ͬʱ�����ֵ��е������ַ���s��t������һ���任��ÿ�ο��Ըı��ַ����е�����һ���ַ���
�����һ���㷨��������s�任��t��������ٲ�����ͬʱ��Ҫ�����ڱ任�����е�ÿ���������ֵ��еĴ���

����һ��string����dic��ͬʱ���������Сn����s�ʹ�t���뷵����s��t�任��������ٲ��������޷��任��t�򷵻�-1��
��֤�ַ������Ⱦ�С�ڵ���10�����ֵ����ַ�������С�ڵ���500��
����������

["abc","adc","bdc","aaa��],4,��abc","bdc"

���أ�2

 * @author wqx
 *
 */
public class _18_10_CountStrChanges {

	/**
	 * ˼·��
	 * �任���̿���ģ���һ������ͼ��ͼ��ÿ���ڵ��Ǵ���һ���ַ�������ÿ��������������һ���ַ��任��
	 * 
	 * ������Ҫ�ҳ���С�ı任��������ô���ǶԸ�ͼ���й�������������ɡ�
	 * 
	 * @param dic
	 * @param n
	 * @param s
	 * @param t
	 * @return
	 */
    public int countChanges(String[] dic, int n, String s, String t) {
    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(s);
    	boolean[] visited = new boolean[n];
    	int count = 0;
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		//����ͬһ��ȵĽڵ�
    		for(int i = 0; i < size; i++){
    			String str = queue.poll();
    			if(str.equals(t)){
    				return count;
    			}
    			//��ÿ���ڵ㣬Ѱ�ҿ��ܵ���һ��״̬�ڵ�
    			for(int j = 0; j < dic.length; j++){
    				if(check(str,dic[j]) && !visited[j]){
    					visited[j] = true;
    					queue.offer(dic[j]);
    				}
    			}
    		}
    		count++;
    	}
    	return count;
    }
    public boolean check(String src,String dest){
    	int differs = 0;
    	if(src.length() != dest.length()) return false;
    	for(int i = 0; i < src.length(); i++){
    		if(src.charAt(i) != dest.charAt(i)){
    			differs++;
    		}
    		if(differs > 1)	return false;
    	}
    	if(differs == 1)
    		return true;
    	return false;
    }
	public static void main(String[] args) {
		String[] dic = {"abc","adc","bdc","aaa"};
		int n = 4;
		String s = "abc", t = "bdc";
		System.out.println("res:" + new _18_10_CountStrChanges().countChanges(dic, n, s, t));
	}

}
