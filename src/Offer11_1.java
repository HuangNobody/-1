public class Offer11_1 {
	
	public double Power(double base, int exponent){
		double result = 1.0;
		for(int i =1;i<=exponent;i++){
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		Offer11_1 of111 = new Offer11_1();
		//测试用例
		System.out.println("底数为2,指数为2的运行结果："+ of111.Power(2, 2));
		System.out.println("底数为2,指数为-2的运行结果："+ of111.Power(2, -2));//没考虑这种情况
		System.out.println("底数为2,指数为0的运行结果："+ of111.Power(2, 0));//没考虑这种情况
		System.out.println("底数为2,指数为1的运行结果："+ of111.Power(2, 1));
		System.out.println("底数为-2,指数为2的运行结果："+ of111.Power(-2, 2));
		System.out.println("底数为-2,指数为-2的运行结果："+ of111.Power(-2, -2));//没考虑这种情况
		System.out.println("底数为-2,指数为0的运行结果："+ of111.Power(-2, 0));
		System.out.println("底数为0,指数为2的运行结果："+ of111.Power(0, 2));
		System.out.println("底数为0,指数为-2的运行结果："+ of111.Power(0, -2));//运行结果错误
		System.out.println("底数为0,指数为0的运行结果："+ of111.Power(0, 0));//运行结果错误
	}
}
