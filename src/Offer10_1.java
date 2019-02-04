public class Offer10_1 {

	//解法1，可能引起死循环的解法
	public int NumberOf1(int n){
		int count = 0;
		while(n != 0){//有可能是负数
			if((n&1) !=0)//如果n&1外面没有各异括号的话，会报错，提示"&"符号未定义
				count++;
			n = n>>1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Offer10_1 o101 = new Offer10_1();
		//测试用例
		//1，正数（包括边界值1、0x7FFFFFFF）
		
		int n1 = 1;
		System.out.println("输入数字：" + n1 + " ,二进制中1的个数：" + o101.NumberOf1(n1));
		int n2 = 0x7FFFFFFF;
		System.out.println("输入数字：" + n2 + " ,二进制中1的个数：" + o101.NumberOf1(n2));
		
		//3，0
		int n5 = 0;//如果把测试用例3放在测试用例2后面，因为2的两个测试用例都会陷入死循环，故测试用例3不会有输出
		System.out.println("输入数字：" + n5 + " ,二进制中1的个数：" + o101.NumberOf1(n5));
		
		//2,负数（包括边界值0x80000000,0xFFFFFFFF）
		int n3 = 0x80000000;//死循环，运行时没有输出。（也没有卡死，奇怪）
		System.out.println("输入数字：" + n3 + " ,二进制中1的个数：" + o101.NumberOf1(n3));
		int n4 = 0xFFFFFFFF;//死循环，运行时没有输出。（也没有卡死，奇怪）
		System.out.println("输入数字：" + n4 + " ,二进制中1的个数：" + o101.NumberOf1(n4));
	}
}
