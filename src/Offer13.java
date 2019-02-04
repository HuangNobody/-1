//前提：假设要删除的节点存在于链表中
//删除i节点，先把i的下一个节点j的内容复制到i，然后把节点i的指针指向节点j的下一个节点

public class Offer13 {
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode delete(ListNode headNode, ListNode ToBeDeleteNode){
		// 1.如果链表为空，或者要删除的节点为空，返回
		if(headNode == null || ToBeDeleteNode == null)
			return null;
		
		//要删除的节点不是尾节点
		if(ToBeDeleteNode.next != null){//开始时我这里把ToBeDeleteNode.next的next忘了，结果出现空指针异常
			ListNode tempNode = ToBeDeleteNode.next;// 要建一个临时节点保存toBeDeleted的next节点
			ToBeDeleteNode.val = tempNode.val;
			ToBeDeleteNode.next = tempNode.next;
			
			tempNode = null;
		}else if(headNode == ToBeDeleteNode){  //链表只有一个节点，删除头节点（也是尾节点）
			ToBeDeleteNode = null;
			headNode = null;
		}else{                         //链表中有多个节点，删除尾节点
			ListNode tempNode = headNode;
			while(tempNode.next != ToBeDeleteNode)
				tempNode = tempNode.next;
			
			tempNode.next = null;
			ToBeDeleteNode = null;
		}
		return headNode;
	}
	
	public void print(ListNode headNode){
		if(headNode == null)
			System.out.println("List is null");
		while(headNode != null){
			System.out.print(headNode.val+", ");
			headNode = headNode.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Offer13 of13 = new Offer13();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		//测试用例
		//1，功能测试，
		System.out.println("链表中有多个结点，删除头结点:");
		of13.print(of13.delete(node1, node1));
		
		System.out.println("链表中有多个结点，删除中间的一个结点:");
		of13.print(of13.delete(node1, node3));
		
		System.out.println("链表中有多个结点，删除尾结点:");
		of13.print(of13.delete(node1, node5));
		
		System.out.println("链表中只有一个节点，删除结点:");
		of13.print(of13.delete(node5, node5));
		
		//2,特殊输入测试，（指向链表头节点指针为NULL指针）
		System.out.println("指向链表头节点指针为NULL指针:");
		of13.print(of13.delete(null, node5));
		
		//指向要删除的节点为NULL指针
		System.out.println("指向要删除的节点为NULL指针:");
		of13.print(of13.delete(node1, null));
		
	}
}
