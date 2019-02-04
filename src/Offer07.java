import java.util.Stack;

public class Offer07 {
	
	private static Stack<Object> stack1 = new Stack<>();
	private static Stack<Object> stack2 = new Stack<>();
	
	//加入队列中的元素只加入到栈1中
	public static void appendTail(Object item){
		stack1.push(item);
		System.out.println("压入栈元素：" + item);
	}
	
	/*
	 * 删除一个元素时，检查栈 2是否为空，栈2不为空则弹出栈2栈顶元素，栈2为空，则把栈1中的元素全部弹出、压入到栈2中，
	 * 然后从栈2栈顶弹出元素
	 */
	public static void deleteHead(){
		if(!stack2.isEmpty())
			System.out.println("弹出栈元素:" +stack2.pop());
		else{
			if(stack1.isEmpty())
				throw new RuntimeException("队列为空");
			while(!stack1.isEmpty()){
				Object item = stack1.pop();
				stack2.push(item);
			}
			deleteHead();//当之前stack2为空，经过入站后不空了，调用这句删除栈顶元素
		}
	}
	
	public static void main(String[] args) {
		//测试用例
		//Offer07 o7 = new Offer07();
		//o7.appendTail(1);
		//1，往空的队列里删除元素
		//deleteHead();
		//1，往空的队列里添加元素
		appendTail(1);
		
		//2,往非空的队列里添加元素
		appendTail(2);
		appendTail(3);
		//2,往非空的队列里删除元素
		deleteHead();
		
		//3，连续删除元素直至队列为空
		deleteHead();
		deleteHead();
	}
}
