package edu.ouc.cc150;

/**
 * ��Ŀ����

�����ַ��ظ����ֵĴ�������дһ��������ʵ�ֻ������ַ���ѹ�����ܡ����磬�ַ�����aabcccccaaa����ѹ�����ɡ�a2b1c5a3������ѹ������ַ���û�б�̣��򷵻�ԭ�ȵ��ַ�����

����һ��string iniStringΪ��ѹ���Ĵ�(����С�ڵ���3000)����֤�����ַ����ɴ�СдӢ����ĸ��ɣ�����һ��string��Ϊ�����ѹ�����δ�仯�Ĵ���
��������

"aabcccccaaa"

���أ�"a2b1c5a3"

"welcometonowcoderrrrr"

���أ�"welcometonowcoderrrrr"
 * @author wqx
 *
 */
public class _1_5_ZipString {

	/**
	 * ע������Խ�缰�߽�ֵ�ô���
	 * 
	 * ����ʱ�䣺51ms
	 * ռ���ڴ棺809k
	 * 
	 * @param iniString
	 * @return
	 */
	public static String zipString(String iniString) {
		StringBuilder sb = new StringBuilder("");
		int len = iniString.length();
		for(int i = 0,j = 0; i < len; ){
			sb.append(iniString.charAt(i));
			j = i+1;
			while(j < len && iniString.charAt(j) == iniString.charAt(i)){ j++;}
			sb.append(j-i);
			i = j;
		}
		if(sb.length() >= len){
			return iniString;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "jjjjjjxxxxxxxooZLLLLLLLLQQQQQQQQQLLLLLLLLECXXXXXXXIIIIIIIIIhjjyyySSooooooooommmuuEEEEEEEEEnnnnnnnffffffAAAAAllllllllbbbbkkkkkkkkkkkkKKKKKKhhhhhhhhhooooooooooYCCCCCCOOOOOOOOOMMMMMMMMMMiiiiiivvvvvvvWWWWkkkkkkwwwwwwwMmmmmmmmmLLLwwwwwwwkkkjjjjjjttttQQQQQQQQQaaaaaaaFFFFFFFlllllllllggggggggggPPPPPPuuuuuuuuaYYYYYYwQQQFFFFFFFFFFaaaaapXXXXXXXxxxxxxQQQQQQQQQsssssGGGGfffffffddddddpppQQQQQQHHHTTTaaaaaaGGGGGGddyyyyyMhhllllllllllNNNNNNNNUUUWWWWWWLLLLLLLLLYYYYYYYYYYTTKKKKKKKKiiiiiiitttttttXXXXXXXXXLLLHZZZZZZZssssjjJJJEEEEEOOOOOttttttttttBBttttttTTTTTTTTTTrrrrttttRRRRRyyooooooaaaaaaaaarrrrrrrPPPPPPPjjPPPPddddddddddHHHHnnnnnnnnnnSSSSSSSSSSzzHHHHHHHHHddddddDDDzzzhhhhhfffffffffftttttteeeeeeeeEEEEEEEEEaaaaaaccccccccccFFFFFFFF";
		System.out.println("res:" + zipString(str));
	}

}
