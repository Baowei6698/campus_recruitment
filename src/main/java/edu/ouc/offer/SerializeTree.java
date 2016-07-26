package edu.ouc.offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树 
 * 存储格式按完全二叉树形式：
 *   1
 *  / \
 * 2   3
 *    /
 *   4
 * 序列化后：
 * 1,2,3,#,#,4,#,#,#
 * 
 * 
 * @author wqx
 */
public class SerializeTree {

	private int level;
	
	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder("");
		if(root == null){
			sb.append("#,");
			return sb.toString();
		}
		sb.append( root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
	TreeNode Deserialize(String str) {
		
		String[] nodes = str.split(",");
		TreeNode node = null;
		if(!"#".equals(nodes[0])){
			node = new TreeNode(Integer.parseInt(nodes[0]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
