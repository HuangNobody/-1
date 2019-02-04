//两个队列模拟一个栈
import java.util.LinkedList;
import java.util.Queue;

public class Offer07_more {
	
	private static Queue<Object> queue1= new LinkedList<>();
	private static Queue<Object> queue2= new LinkedList<>();
	
	//加入栈中的元素只加入到队列1中,入队
	public static void push(Object item){
		queue1.add(item);
		System.out.println("压入队列元素：" + item);
	}
	
	public void pop(){ //出队，出队判空。必须是非空的栈才能出栈啊
		if(queue1.size() <=1){
			System.out.println("弹出队列元素："+queue1.poll());
		}else{
			while(queue1.size() > 1){
				queue2.add(queue1.poll());
			}
		}
		
		while(queue2.size() > 0){
			queue1.add(queue2.poll());
		}
		
		System.out.println("弹出队列元素："+queue1.poll());
	}
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		Offer07_more o7m = new Offer07_more();
		o7m.pop();
		o7m.pop();
		o7m.pop();
	}

}
