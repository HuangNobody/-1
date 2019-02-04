package Test_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	//前序递归实现
	public void preOrderRe(TreeNode root){
		//System.out.println(biTree.value);
		if(root != null){
			System.out.print(root.getData()+", ");
			preOrderRe(root.getLeft());
			preOrderRe(root.getRight());
		}
	}
	
	//前序非递归的方式
	public void preOrderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		while(true){
			while(root !=null){
				System.out.print(root.getData()+", ");
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty()) break;//遍历完最后一个节点时调用这一句跳出循环
			root = stack.pop();
			root = root.getRight();
		}
	}
	
	//中序遍历+递归
	public void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.getLeft());
			System.out.print(root.getData()+", ");
			inOrder(root.getRight());
		}
	}
	
	//中序遍历+非递归
	public void inOrderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		while(true){
			while(root != null){
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty()) break;
			root = stack.pop();
			System.out.print(root.getData()+", ");
			root = root.getRight();
		}
	}
	
	//后序遍历+递归
	public void postOrder(TreeNode root){
		if(root != null){
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData()+", ");
		}
	}
	
	//后续遍历+非递归(这是最难的一个)
	public void postOrderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		while(true){
			if(root !=null){
				stack.push(root);
				root = root.getLeft();
			}else{
				if(stack.isEmpty()) return;
				
				if(stack.lastElement().getRight() == null){//Vector中lastElement(),Returns the last component of the vector.
					root = stack.pop();
					System.out.print(root.getData()+", ");
					while(root == stack.lastElement().getRight()){
						System.out.print(stack.lastElement().getData()+", ");
						root = stack.pop();
						if(stack.isEmpty()){
							break;
						}
					}
				}
				
				if(!stack.isEmpty())
					root = stack.lastElement().getRight();
				else
					root = null;
			}
		}
	}
	
	//层序遍历
	/*offer，add区别：
	 *  一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。 这时新的offer 方法
	 * 就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。 
	 *  poll，remove区别： 
	 *  remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 
	 *  但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
	 */
	public void levelOrder(TreeNode root){
		TreeNode temp;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			temp = queue.poll();
			System.out.print(temp.getData()+", ");
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
	}
	
	public static void main(String[] args) {
		//注意如果创建使用函数二叉树，则必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，
		//而初始化是按顺序初始化的，不逆序建立会报错；如果不适用函数创建二叉树，像下面这样做，不必用逆序建立
		TreeNode node9 = new TreeNode(8,null, null);
		TreeNode node8 = new TreeNode(4,null, null);
		TreeNode node7 = new TreeNode(2, null, null);
		TreeNode node6 = new TreeNode(7,null, node9);
		TreeNode node5 = new TreeNode(5,node8, null);
		TreeNode node4 = new TreeNode(1, null, node7);
		TreeNode node3 = new TreeNode(9, node6, null);
		TreeNode node2 = new TreeNode(3, node4, node5);
		TreeNode node1 = new TreeNode(6, node2,node3);
		
		BinaryTree tree = new BinaryTree();
		System.out.println("先序遍历二叉树（递归）：");
		tree.preOrderRe(node1);
		System.out.println();
		
		System.out.println("先序遍历二叉树（非递归）：");
		tree.preOrderNonRecursive(node1);
		System.out.println();
		
		System.out.println("中序遍历二叉树（递归）：");
		tree.inOrder(node1);
		System.out.println();
		
		System.out.println("中序遍历二叉树（非递归）：");
		tree.inOrderNonRecursive(node1);
		System.out.println();
		
		System.out.println("后序遍历二叉树（递归）：");
		tree.postOrder(node1);
		System.out.println();
		
		System.out.println("后序遍历二叉树（非递归）：");
		tree.postOrderNonRecursive(node1);
		System.out.println();
		
		System.out.println("层序遍历二叉树（递归）：");
		tree.levelOrder(node1);
		System.out.println();
	}
}

