package edu.ouc.algorithm.graph;

public class Graph {
	/**
	 * ÁÚ½Ó¾ØÕó
	 */
	public  int arcs[][];
	/**
	 * ÁÚ½Ó±í
	 */
	public   Entry[] vertices;
	
	public  int vexnum;
	public  int arcnum;

	public static Graph createGraph(int g[][],boolean isMatrix){
		Graph graph = new Graph();
		graph.vexnum = g.length;
		if(isMatrix){
			graph.arcs = new int[graph.vexnum][graph.vexnum];
			for(int i = 0; i < graph.vexnum; i++){
				for(int j = 0; j < graph.vexnum; j++){
					graph.arcs[i][j] = g[i][j];
				}
			}
		}
		return graph;
	}
	class Entry{
		private int elem;
		private Entry next;

		public Entry(int elem,Entry next){
			this.elem = elem;
			this.next = next;
		}
		public int getElem() {
			return elem;
		}
		public Entry getNext() {
			return next;
		}
	}
}
