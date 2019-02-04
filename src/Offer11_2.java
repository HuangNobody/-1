public class Offer11_2 {
	
	public double Power(double base, int exponent){
		if(equal(base, 0.0) && exponent < 0)
			throw new RuntimeException("while exponent is minus, the base can't be zero");
		int absExponent = exponent;
		if(exponent < 0)
			absExponent = ~exponent +1;//整数按位取反+1得到它的相反数，-2与+2互为相反数
		double result = powerWithUnsignedExponent(base, absExponent);
		if(exponent<0)
			result = 1.0/result;
		return result;
	}
	
	public boolean equal(double number1, double number2){
		if(number1 - number2 > -0.0000001 && (number1-number2) < 0.0000001)
			return true;
		return false;
	}
	
	public double powerWithUnsignedExponent(double base, double exponent){
		double result = 1.0;
		for(int i =1;i<=exponent;i++){
			result *= base;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Offer11_2 of112 = new Offer11_2();
		//测试用例
		System.out.println("底数为2,指数为2的运行结果："+ of112.Power(2.0, 2));
		System.out.println("底数为2,指数为-2的运行结果："+ of112.Power(2, -2));
		System.out.println("底数为2,指数为0的运行结果："+ of112.Power(2, 0));
		System.out.println("底数为2,指数为1的运行结果："+ of112.Power(2, 1));
		System.out.println("底数为-2,指数为2的运行结果："+ of112.Power(-2, 2));
		System.out.println("底数为-2,指数为-2的运行结果："+ of112.Power(-2, -2));
		System.out.println("底数为-2,指数为0的运行结果："+ of112.Power(-2, 0));
		System.out.println("底数为0,指数为2的运行结果："+ of112.Power(0, 2));
		System.out.println("底数为0,指数为-2的运行结果："+ of112.Power(0, -2));
		System.out.println("底数为0,指数为0的运行结果："+ of112.Power(0, 0));
	}
}
