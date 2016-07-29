package edu.ouc.algorithm.graph;

public class MST_Prim {
	
	public static void main(String args[]){
		int [][] g = {{0,6,1,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
						{6,0,5,Integer.MAX_VALUE,3,Integer.MAX_VALUE},
						{1,5,0,5,6,4},
						{5,Integer.MAX_VALUE,5,0,Integer.MAX_VALUE,2},
						{Integer.MAX_VALUE,3,6,Integer.MAX_VALUE,0,6},
						{Integer.MAX_VALUE,Integer.MAX_VALUE,4,2,6,0}
					 };
		Graph graph = Graph.createGraph(g, true);
		prim(graph);
	}
	public static void prim(Graph graph){
		int closest[] = new int[graph.vexnum];
		int lowcost[] = new int[graph.vexnum];
		int visited[] = new int[graph.vexnum];
		
		//辅助数组初始化
		for(int i = 0; i < graph.vexnum; i++){
				lowcost[i] = graph.arcs[0][i];
				visited[i] = 0;
				closest[i] = 0;
		}
		visited[0] = 1;
		for(int i = 1; i < graph.vexnum; i++){
			int min = Integer.MAX_VALUE;
			int v = -1;
			for(int j = 1; j < graph.vexnum; j++){
				if(visited[j] != 1 && lowcost[j] < min){
					min = lowcost[j];
					v = j;
				}
			}
			if(v != -1){
				visited[v] = 1;
				//更新lowcost[]和closet
				for(int j = 1; j < graph.vexnum; j++){
					if(visited[j] != 1 && graph.arcs[v][j] < lowcost[j]){
						lowcost[j] = graph.arcs[v][j];
						closest[j] = v;
					}
				}
			}
		}
	}
	
	public static void print(Graph graph){
		for(int i = 0; i < graph.vexnum; i++){
			for(int j = 0; j < graph.vexnum; j++){
				System.out.print(graph.arcs[i][j] + "  ");
			}
			System.out.println();
		}
	}
}	
