public class Offer10_3 {
	
	public int NumberOf3(int n){
		int count = 0;
		while(n!=0){
			count++;
			n = (n-1)&n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Offer10_3 o103 = new Offer10_3();
		//测试用例
		//1，正数（包括边界值1、0x7FFFFFFF）
			
		int n1 = 1;
		System.out.println("输入数字：" + n1 + " ,二进制中1的个数：" + o103.NumberOf3(n1));
		int n2 = 0x7FFFFFFF;
		System.out.println("输入数字：" + n2 + " ,二进制中1的个数：" + o103.NumberOf3(n2));
			
		//3，0
		int n5 = 0;//如果把测试用例3放在测试用例2后面，没有问题！！！！！！！
		System.out.println("输入数字：" + n5 + " ,二进制中1的个数：" + o103.NumberOf3(n5));
		
		//2,负数（包括边界值0x80000000,0xFFFFFFFF）
		int n3 = 0x80000000;//没有死循环
		System.out.println("输入数字：" + n3 + " ,二进制中1的个数：" + o103.NumberOf3(n3));
		int n4 = 0xFFFFFFFF;//没有死循环
		System.out.println("输入数字：" + n4 + " ,二进制中1的个数：" + o103.NumberOf3(n4));	
	}
}
