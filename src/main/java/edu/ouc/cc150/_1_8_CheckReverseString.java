package edu.ouc.cc150;


/**
 * ��Ŀ����

�ٶ����Ƕ�֪���ǳ���Ч���㷨�����һ�������Ƿ�Ϊ�����ַ������Ӵ����뽫����㷨��д��һ�����������������ַ���s1��s2��
���д������s2�Ƿ�Ϊs1��ת���ɣ�Ҫ��ֻ�ܵ���һ�μ���Ӵ��ĺ�����

���������ַ���s1,s2,�뷵��boolֵ����s2�Ƿ���s1��ת���ɡ��ַ������ַ�ΪӢ����ĸ�Ϳո����ִ�Сд���ַ�������С�ڵ���1000��
����������

"Hello world","worldhello "

���أ�false

"waterbottle","erbottlewat"

���أ�true

 *
 * @author hzwuqingxin
 */
public class _1_8_CheckReverseString {
    public boolean checkReverseEqual(String s1, String s2) {
        String str = s2 + s2;
        return str.contains(s1);
    }
}
