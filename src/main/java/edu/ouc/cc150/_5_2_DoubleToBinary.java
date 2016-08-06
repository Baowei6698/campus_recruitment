package edu.ouc.cc150;

/**
 * ��Ŀ����

��һ������0��1֮���ʵ��������Ϊdouble���������Ķ����Ʊ�ʾ������������޷���ȷ����32λ���ڵĶ����Ʊ�ʾ��
���ء�Error����

����һ��double num����ʾ0��1��ʵ�����뷵��һ��string����������Ķ����Ʊ�ʾ���ߡ�Error����
����������

0.625

���أ�0.101

 * @author wqx
 *
 */
public class _5_2_DoubleToBinary {

	/**
	 * double*2,ȡ��
	 * 
	 * @param num
	 * @return
	 */
	public static String printBin(double num) {
		StringBuilder sb = new StringBuilder("");
		do{
			if(sb.length() == 32){
				return "Error";
			}
			double tmp = num * 2;
			sb.append((int)tmp);
			num = tmp - (int)tmp;
		}while(num != 0);
		
		return "0." + sb.toString();
	}
	public static void main(String[] args) {
		double num = 0.03125;
		System.out.println("res:" + printBin(num));
		
	}
	public void intToBinary(int a){
		char[] buf = new char[32];
		int pos = 32;
		int radix = 2;
		do{
			buf[--pos] = (char) ('0' + a % radix);
			a /= radix;
		}while(a != 0);
		String res = new String(buf,pos,(32-pos));
		System.out.println("a:" + res);
	}
}
