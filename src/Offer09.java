public class Offer09 {
	
	//递归，效率很低，面试官不会喜欢
	public long Fibonacci_Recursive(int n){
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		return Fibonacci_Recursive(n-1) + Fibonacci_Recursive(n-2);
	}
	
	//时间复杂度O(n)，主要看这个
	public long Fibonacci(int n){
		int result[] = {0,1};
		if(n<2)
			return result[n];
		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		for(int i = 2;i<=n;i++){
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusOne = fibN;
			fibNMinusTwo = fibNMinusOne;
		}
		return fibN;
	}
	
	public static void main(String[] args) {
		
		Offer09 of9 = new Offer09();
		
		//测试用例
		//1，功能测试（如输入3，5，10等）
		int n1 = 3;
		System.out.println("输入数字："+n1+", 输出结果:"+of9.Fibonacci(n1));
		int n2 = 5;
		System.out.println("输入数字："+n2+", 输出结果:"+of9.Fibonacci(n2));
		int n3 = 10;
		System.out.println("输入数字："+n3+", 输出结果:"+of9.Fibonacci(n3));
		
		//2,边界值测试（如输入0，1，2）
		int n4 = 0;
		System.out.println("输入数字："+n4+", 输出结果:"+of9.Fibonacci(n4));
		int n5 = 1;
		System.out.println("输入数字："+n5+", 输出结果:"+of9.Fibonacci(n5));
		int n6 = 2;
		System.out.println("输入数字："+n6+", 输出结果:"+of9.Fibonacci(n6));
		
		//3，性能测试（输入较大的数字，如40，50，100等）
		int n7 = 40;
		System.out.println("输入数字："+n7+", 输出结果:"+of9.Fibonacci(n7));
		int n8 = 50;
		System.out.println("输入数字："+n8+", 输出结果:"+of9.Fibonacci(n8));
		int n9 = 100;//运算结果超出了long的范围，故输出为0
		System.out.println("输入数字："+n9+", 输出结果:"+of9.Fibonacci(n9));
	}
}
