package edu.ouc.cc150;

/**
 * 
题目描述

请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。

给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
测试样例：

"Mr John Smith”,13

返回："Mr%20John%20Smith"

”Hello  World”,12

返回：”Hello%20%20World”


 * @author wqx
 *
 */
public class _1_4_ReplaceSpace {

	/**
	 * 运行时间：46ms
	 * 占用内存：777k
	 * 
	 * @param iniString
	 * @param length
	 * @return
	 */
    public static String replaceSpace(String iniString, int length) {
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0 ; i < length; i++){
        	if(0x20 == iniString.charAt(i)){
        		sb.append("%20");
        	}else{
        		sb.append(iniString.charAt(i));
        	}
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		String str = "sArcCNxjNaviToUsSN QiTtx j bgUhhIoiSfszja QfFkxk JwYOoFSg dhdMKgTxjRrcATfkb ELqIebLGZk kAESkrNJxbmci nyojZqX vawG kxvqf moWAA m aMuilydRRNvVuh Uss mJtnZb zA oF cx hUQD V dSLSLcbjXLydl V dReEozdi ZO IxbW CgcTeobRrmco ELs cQh K xlg Pj cGaO yXKXy hs kmJaSdNV Z InShcp AxoM hHLTsIMhcHKnArxgRVjh MclqtzFpl yzaWlhLfYlfxNFgb";
		int len = 331;
		System.out.println("result:" + replaceSpace(str,str.length()));

	}

}
