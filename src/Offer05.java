import java.util.ArrayList;
import java.util.Stack;

//定义链表结构,这里入股这部分代码放到类Offer05里面就会报错；如果非把ListNode放到类Offer05里面就要在class ListNode{...}前面加上static
class ListNode{
	ListNode next;
	int val;
}

public class Offer05 {
		
		
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<>();
		if(listNode == null)
			return list;
		Stack<ListNode> stack = new Stack<>();
		while(listNode != null){
			stack.push(listNode);
			listNode = listNode.next;
		}
		
		while(!stack.isEmpty()){
			list.add(stack.pop().val);
		}
		return list;
	}
	public static void main(String[] args) {
		Offer05 of5 = new Offer05();
		//测试用例
		//1，功能测试（输入的链表有多个节点，输入的链表只有一个节点）
		ListNode node1 = new ListNode();
		ListNode node2 = new ListNode();
		ListNode node3 = new ListNode();
		node1.val = 1;
		node2.val = 2;
		node3.val = 3;
		node1.next = node2;
		node2.next = node3;
		System.out.println(of5.printListFromTailToHead(node1));
		
		ListNode node4 = new ListNode();
		node4.val = 4;
		System.out.println(of5.printListFromTailToHead(node4));
		
		//2,特殊输入测试（输入的链表头节点指针为null）
		ListNode node5 = null;
		System.out.println(of5.printListFromTailToHead(node5));
	}
}
	

