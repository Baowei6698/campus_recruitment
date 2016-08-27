package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
题目描述

请编写一个方法，对一个字符串数组进行排序，将所有变位词合并，保留其字典序最小的一个串。
这里的变位词指变换其字母顺序所构成的新的词或短语。例如"triangle"和"integral"就是变位词。

给定一个string的数组str和数组大小int n，请返回排序合并后的数组。保证字符串串长小于等于20，
数组大小小于等于300。
测试样例：

["ab","ba","abc","cba"]

返回：["ab","abc"]



 * @author wqx
 *
 */
public class _11_2_SortString {

	/**
	 * 思路：
	 * 对进行所有字符串分别按字符顺序排序，合并相同的字符串
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
		//按字典序排序，为了保证set.add的时候第一次新增的是相同变位词字典序最小的一个串
		Arrays.sort(strs);
		Set<OtherString> set = new HashSet<>();
		//利用set特性，将相同变位词合并
		for(int i = 0; i < n; i++){
			set.add(strs[i]);
		}
		ArrayList<String> list = new ArrayList<>(set.size());
		Iterator<OtherString> it = set.iterator();
		while(it.hasNext()){
			list.add(it.next().str);
		}
		//结果字典序排序
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
