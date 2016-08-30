package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��Ŀ����

���޺���һ����������Ϸ����Ϸ��һ����Ҫվ����һ���˵ļ���ϡ�Ϊ��ʹ���ɵ��޺����ȹ̣�
����Ӧ����������˱�������˸���һ�㡣����һ����Ϸ��Ҫ���������Ŀ��Ϊ���Ӿ�Ч����
���ǻ�Ҫ��������˵���߱�������˸ߡ����дһ���㷨����������ܵ������ˣ�ע������������Ա��ͬʱ���֡�

����һ����άint������actors��ÿ��Ԫ��������ֵ���ֱ����һ����Ա����ߺ����ء�
ͬʱ������Ա����n���뷵������ܵ�����������֤������С�ڵ���500��
����������

[[1,2],[3,4],[5,6],[7,8]],4

���أ�4

 * @author wqx
 *
 */
public class _11_7_2_LIS_II {

	/**
	 * ��άLIS,�Ȱ�����ά�������ڶ����ؽ���LIS���
	 * 
	 * @param actors
	 * @param n
	 * @return
	 */
    public int getHeight(int[][] actors, int n) {
    	Actor[] actorList = new Actor[n];
    	for(int i = 0; i < n; i++){
    		Actor act = new Actor(actors[i][0],actors[i][1]);
    		actorList[i] = act;
    	}
    	//�����ά������
    	Arrays.sort(actorList,new Comparator<Actor>(){
			@Override
			public int compare(Actor o1, Actor o2) {
				// TODO Auto-generated method stub
				return o1.height - o2.height;
			}
    	});
    	int f[] = new int[n];
    	f[0] = 1;
    	int res = 1;
    	for(int i = 1; i < n; i++){
    		f[i] = 1;
    		for(int j = 0; j < i; j++){
    			if(actorList[j].weight < actorList[i].weight && f[j] + 1 > f[i]){
    				f[i] = f[j] + 1;
    				if(f[i] > res)
    					res = f[i];
    			}
    		}
    	}
    	return res;
    }
    static class Actor{
    	int height;
    	int weight;
    	public Actor(int height, int weight){
    		this.height = height;
    		this.weight = weight;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
