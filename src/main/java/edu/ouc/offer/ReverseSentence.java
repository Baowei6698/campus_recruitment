package edu.ouc.offer;

/**
 * 
��Ŀ����
ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У�
���ܰ�����ô��


 * @author wqx
 *
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0 || str.trim().equals("")) return str;
        String[] tmp = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = tmp.length-1; i > 0; i--){
        	sb.append(tmp[i]).append(" ");
        }
        sb.append(tmp[0]);
        return sb.toString();
    }
}
