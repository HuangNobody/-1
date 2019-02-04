package Test_1;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(){};
	
	TreeNode(int data,TreeNode left, TreeNode right){
		super();//千万别忘了，不然会出错，如果没有这句在node9实例化时报错
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public void setLeft(TreeNode left){
		this.left = left;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public void setRight(TreeNode right){
		this.right = right;
	}
}
