package edu.ouc.cc150;

/**
 * 
��Ŀ����

���дһ�����������ַ����еĿո�ȫ���滻Ϊ��%20�����ٶ����ַ������㹻�Ŀռ����������ַ�������֪���ַ�������ʵ����(С�ڵ���1000)��ͬʱ��֤�ַ����ɴ�Сд��Ӣ����ĸ��ɡ�

����һ��string iniString Ϊԭʼ�Ĵ����Լ����ĳ��� int len, �����滻���string��
����������

"Mr John Smith��,13

���أ�"Mr%20John%20Smith"

��Hello  World��,12

���أ���Hello%20%20World��


 * @author wqx
 *
 */
public class _1_4_ReplaceSpace {

	/**
	 * ����ʱ�䣺46ms
	 * ռ���ڴ棺777k
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
