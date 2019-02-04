import java.util.Arrays;

public class Offer12_2 {
	
	public void print1ToMaxNDigits(int n){
		if(n<0)
			return;
		char [] number = new char[n];
		for(int i = 0;i<10;i++){//这里是i<10,不是i<n
			number[0] = (char) (i+ '0');
			print1ToMaxOfNDigitsRecursively(number, n, 0);
		}
	}
	
	private void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
		if(index == length-1){
			printNumber(number);
			return;
		}
		
		for(int i= 0;i<10;i++){
			number[index+1] = (char) (i+'0');
			print1ToMaxOfNDigitsRecursively(number, length,index+1);
		}
	}

	public void printNumber(char[] number){//打印字符串表示的数字，只有在碰到第一个非0的字符之后才可是打印
		int nLength = number.length;
		int i =0;
		while(i<nLength && number[i] == '0') //i < size在前，否则越界
			i++;
		if(i == nLength)
			return;
		char[] printNum = Arrays.copyOfRange(number, i, nLength);//复制数组
		System.out.println(printNum);	
	}
	
	public static void main(String[] args) {
		//测试用例
		//功能测试（输入1，2，3.。。
		Offer12_2 of122 = new Offer12_2();
		//System.out.println("输入1，输出从1到最大的1位数：");
		//of122.print1ToMaxNDigits(1);
		System.out.println("输入2，输出从1到最大的2位数：");
		of122.print1ToMaxNDigits(2);
		System.out.println("输入3，输出从1到最大的3位数：");
		of122.print1ToMaxNDigits(3);
		
		//特殊输入测试（输入-1，0）
		System.out.println("输入-1，输出从1到最大的-1位数：");
		of122.print1ToMaxNDigits(-1);
		System.out.println("输入0，输出从1到最大的0位数：");
		of122.print1ToMaxNDigits(0);
	}
}
