package edu.ouc.xiaomi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * С��Git
 * 
��Ŀ����
git��һ�ֲַ�ʽ��������ߣ�gitͨ��������ʽ��¼�ļ��ĸ�����ʷ��
���磺 base'<--base<--A<--A' ^ | --- B<--B' 
С�׹���ʦ������ҪѰ��������֧����ķָ�㣬��base.����git ���Ƕ������
��ʵ��һ���㷨������git�����������������ָ�㡣 
������git���ڵ���Ϊn,���ڽӾ������ʽ��ʾgit�����ַ�������matrix����n���ַ�����
ÿ���ַ������ַ�'0'��'1'��ɣ�����Ϊn��
matrix[i][j]=='1'���ҽ���git���ֵ�i���͵�j���ڵ������ӡ�
�ڵ�0Ϊgit���ĸ��ڵ㡣��

��������:

[01011,10100,01000,10000,10000],1,2

�������:

1

 * @author wqx
 *
 */
public class XiaoMiGit {
    /**
     * ����git�������������ָ��
     * ˼·��
     * DFS����¼��ѯ·�����Ƚ���·���ó������GET������
     * 
     * @param matrix ���ھ��󣬱�ʾgit����matrix[i][j] == '1' 
     * ���ҽ���git���е�i���͵�j���ڵ������ӣ��ڵ�0Ϊgit���ĸ��ڵ�
     * @param indexA �ڵ�A��index
     * @param indexB �ڵ�B��index
     * @return ����
     */
	static boolean flag;
    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
    	int rows = matrix.length;
    	int[] visited = new int [rows+1];
    	List<Integer> path1 = new ArrayList<Integer>();
    	List<Integer> path2 = new ArrayList<Integer>();
    	flag = false;
    	dfs(matrix,indexA,visited,0,path1);
    	flag = false;
    	visited = new int[rows+1];
    	dfs(matrix,indexB,visited,0,path2);
    	for(int i = path1.size()-1; i >= 0; i--){
    		for(int j = path2.size()-1; j >= 0; j--){
    			if(path2.get(j) == path1.get(i)){
    				return path2.get(j);
    			}
    		}
    	}
    	
    	System.out.println(Arrays.toString(path1.toArray()));
    	System.out.println(Arrays.toString(path2.toArray()));
    	return 0;
    }

    public static void dfs(String [] matrix,int target,int visited[],int num,List<Integer> path){
    	if(flag)return;
    	visited[num] = 1;
    	System.out.println("num:" + num);
    	for(int i = 0; i < matrix[num].length(); i++){
    			if(matrix[num].charAt(i) == '1' && visited[i] == 0){
    				path.add(i);
    				if(target == i){
    					flag = true;
    					return ;
    				}
    				dfs(matrix,target,visited,i,path);
    				if(flag)return;
    				path.remove(path.indexOf(i));
    		}
    	}
    }
    public static void main(String[]args){
    	String[] matrix = {"01011","10100","01000","10000","10000"};
    	int indexA = 1,indexB = 2;
    	System.out.println("result:" + getSplitNode(matrix,indexA,indexB));
    }
}
