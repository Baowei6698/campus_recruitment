package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
��Ŀ����

���дһ����������һ���ַ�������������򣬽����б�λ�ʺϲ����������ֵ�����С��һ������
����ı�λ��ָ�任����ĸ˳�������ɵ��µĴʻ�������"triangle"��"integral"���Ǳ�λ�ʡ�

����һ��string������str�������Сint n���뷵������ϲ�������顣��֤�ַ�������С�ڵ���20��
�����СС�ڵ���300��
����������

["ab","ba","abc","cba"]

���أ�["ab","abc"]



 * @author wqx
 *
 */
public class _11_2_SortString {

	/**
	 * ˼·��
	 * �Խ��������ַ����ֱ��ַ�˳�����򣬺ϲ���ͬ���ַ���
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public ArrayList<String> sortStrings(String[] str, int n) {

		OtherString [] strs = new OtherString[n];
		for(int i = 0; i < n; i++){
			strs[i] = new OtherString(str[i]);
		}
		//���ֵ�������Ϊ�˱�֤set.add��ʱ���һ������������ͬ��λ���ֵ�����С��һ����
		Arrays.sort(strs);
		Set<OtherString> set = new HashSet<>();
		//����set���ԣ�����ͬ��λ�ʺϲ�
		for(int i = 0; i < n; i++){
			set.add(strs[i]);
		}
		ArrayList<String> list = new ArrayList<>(set.size());
		Iterator<OtherString> it = set.iterator();
		while(it.hasNext()){
			list.add(it.next().str);
		}
		//����ֵ�������
		Collections.sort(list);
		return list;
	}
	static class OtherString implements Comparable<Object>{
		String str;
		public OtherString(String str){
			this.str = str;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof OtherString){
				OtherString oStr = (OtherString)obj;
				char[] cs = oStr.str.toCharArray();
				Arrays.sort(cs);
				String str1 = new String(cs);

				cs = str.toCharArray();
				Arrays.sort(cs);
				String str2 = new String(cs);

				if(str1.equals(str2))
					return true;
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			char[] cs = str.toCharArray();
			Arrays.sort(cs);
			String s = new String(cs);
			return s.hashCode();
		}

		@Override
		public int compareTo(Object o) {
			String s = ((OtherString)o).str;
			return str.compareTo(s);
		}

		@Override
		public String toString() {
			return str;
		}
	}
	public static void main(String[] args) {
		String[] str = {"emmaldzsvjggzfoda","skmjhsm","zjwmkgufsvwrwyvrhk","vyksgrwwjmwrhzfvuk","wfszrykvjrmuwhkvgw","kwrwuwjvksyvhmrzfg","kom","mko","mko","nezrxmdjgjqexmqz","gjmqdrzqzjeemxxn","qqxedgjjmrznmxez","xxgmjezerjnqmzdq","vwcmmngdsvzx","xvmdvwscgnmz","msnvvczxdgwm","izmvzrhltsiubcukc","cslnzuenr","rznulsenc","lnsnucrez","gkyfvvni","gikvvynf","ivkfyvng","vygfvikn","nwxkeyhnvniquhpapw","wnhyknvanhepwquxip","rrpujexoukmmrnmpdzcf","ksirghrnjx","ixrhgkrnjs","kup","kpu","kpu","emnetqjwnfwi","qpozvklf","qpvkolfz","flpkvoqz","zlkpvfoq","zldjqciktnevrkb","vklqjdrktcebizn","ntrqkvebiljczkd","nkktcebjirqvldz","mytegbucud","gbtcyuemud","gctmuedybu","ahgeomesgcehvk","oamshhecevggek","gmcekevoehsahg","gvgeacmheeoksh","ma","am","am","wxdyddyrenzsylfwx","syedwdylxrwfyxzdn","dwsddyelxywrxyfnz","rdrrfuowxukryfmli","qdjzmdobajs","ymysuotfxpboc","awzccscrkozbhygrkvv","ovrgybhswrczzkcacvk","zcrwkyhrzkgacvsocbv","vzwgzosrkvkcrcybahc","ftytv","ttvyf","tfyvt","vtytf","pggunxuyduy","qijygauutkt","aytqutkugji","itjutqugaky","nfoenumvnmannkkhmueo","ounmkhknefvemnmannou","eonmenfkhmuaonnnumvk","mvnouemekonfamnnnhku","a"};

		int n = 74;

		System.out.println(Arrays.toString(new _11_2_SortString().sortStrings(str, n).toArray()));
		
		OtherString s = new OtherString("kpu");
		OtherString s2 = new OtherString("kup");
		Set<OtherString> set = new HashSet<>(16);
		set.add(s);
		set.add(s2);
		System.out.println("set:" + set);
	}
}
