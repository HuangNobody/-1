import java.util.Arrays;

public class Offer12_1 {
	
	public void print1ToMaxNDigits(int n){
		if(n <= 0)
			throw new RuntimeException("n can't lower zero");
		char []number = new char[n];//如果是c++语言，则这里是n+1，最后一位放“\0”；但是java是n，不要弄混了
		for(int i = 0;i<n;i++){
			number[i] = '0';
		}
		
		while(!increment(number)){
			printNumber(number);
		}
	}
	
	public boolean increment(char[] number){//表示数字的字符串number上增加1
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nLength = number.length;
		for(int i = nLength-1;i>=0;i--){
			int nSum = number[i] - '0' + nTakeOver;
			if(i == nLength-1)
				nSum++;
			
			if(nSum >=10){
				if(i == 0)
					isOverflow = true;
				else{
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			}else{
				number[i] = (char) ('0' + nSum);
				break;
			}
		}
		return isOverflow;
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
		/*
		boolean isBeginning = true;
		int nLength = number.length;
		for(int i =0;i<nLength;i++){
			if(isBeginning && number[i] !='0')
				isBeginning = false;
			if(!isBeginning){
				char[] printNum = Arrays.copyOfRange(number, i, nLength);//复制数组
				System.out.println(printNum);
			}
		}
		这段程序，当n=2时，输出从1到最大的2位数时，例如从11开始，会输出11，1;12，12;13，3...
		*/
	}
	
	public static void main(String[] args) {
		
		//测试用例
		//功能测试（输入1，2，3.。。
		Offer12_1 of121 = new Offer12_1();
		System.out.println("输入1，输出从1到最大的1位数：");
		of121.print1ToMaxNDigits(1);
		System.out.println("输入2，输出从1到最大的2位数：");
		of121.print1ToMaxNDigits(2);

		System.out.println("输入3，输出从1到最大的3位数：");
		of121.print1ToMaxNDigits(3);
		
		//特殊输入测试（输入-1，0）
		System.out.println("输入-1，输出从1到最大的-1位数：");
		of121.print1ToMaxNDigits(-1);
		System.out.println("输入0，输出从1到最大的0位数：");
		of121.print1ToMaxNDigits(0);
	}
}
