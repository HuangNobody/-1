
public class Offer11_3 {
	
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

	public double powerWithUnsignedExponent(double base, int exponent){//开始时我把int exponent
		if(exponent ==0)     //不小心写成double类型，结果exponent >> 1和exponent & 0x1报错：符号>>和&未定义
			return 1;
		if(exponent == 1)
			return base;
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result *= result;
		if((exponent & 0x1) == 1)
			result *= base;
		return result;
	}
	
	public static void main(String[] args) {
		Offer11_3 of113 = new Offer11_3();
		//测试用例
		System.out.println("底数为2,指数为2的运行结果："+ of113.Power(2.0, 2));
		System.out.println("底数为2,指数为-2的运行结果："+ of113.Power(2, -2));
		System.out.println("底数为2,指数为0的运行结果："+ of113.Power(2, 0));
		System.out.println("底数为2,指数为1的运行结果："+ of113.Power(2, 1));
		System.out.println("底数为-2,指数为2的运行结果："+ of113.Power(-2, 2));
		System.out.println("底数为-2,指数为-2的运行结果："+ of113.Power(-2, -2));
		System.out.println("底数为-2,指数为0的运行结果："+ of113.Power(-2, 0));
		System.out.println("底数为0,指数为2的运行结果："+ of113.Power(0, 2));
		System.out.println("底数为0,指数为-2的运行结果："+ of113.Power(0, -2));
		System.out.println("底数为0,指数为0的运行结果："+ of113.Power(0, 0));
	}
}
