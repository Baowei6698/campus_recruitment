package edu.ouc.offer;


/**
 * 
��Ŀ����
���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����

 * @author wqx
 *
 */
public class RectangleCover {
    public int RectCover(int target) {
    	if(target == 0)return 1;
    	if(target == 1){
    		return 1;
    	}else if(target == 2){
    		return 2;
    	}else{
       		return RectCover(target-1)+RectCover(target-2);
    	}
    }
    public static void main(String args[]){
    	RectangleCover c = new RectangleCover();
    	System.out.println(c.RectCover(4));
    }
}
