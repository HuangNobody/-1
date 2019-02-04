public class Offer14_1 {
	
	public void reOrderOddEven(int [] number){
		if(number == null || number.length == 0)
			return ;
		
		int begin = 0;
		int end = number.length-1;
		while(begin<end){//向后移动begin。直到它指向偶数
			while(begin<end && (number[begin]&0x1) != 0)//
				begin++;
			while(begin<end &&(number[end]&0x1) ==0)
				end--;
			if(begin<end){
				int temp = number[begin];
				number[begin] = number[end];
				number[end] =temp;
			}
		}
		
		//输出调整后的数组元素
		for(int i =0;i<number.length;i++){
			System.out.print(number[i]+", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//测试用例1.功能测试
		Offer14_1 of141 = new Offer14_1();
		int [] number1 = {1,2,3,4,5};
		System.out.println("输入数组中的奇数、偶数交替出现：");
		of141.reOrderOddEven(number1);
		
		int [] number2 = {2,4,1,5,3};
		System.out.println("输入的数组中所有偶数都出现在奇数前面：");
		of141.reOrderOddEven(number2);
		
		int [] number3 = {1,5,3,2,4};
		System.out.println("输入的数组中所有奇数都出现在偶数前面：");
		of141.reOrderOddEven(number3);
		
		//特殊输入测试
		int [] number4 = null;
		System.out.println("输入NULL指针：");
		of141.reOrderOddEven(number4);
		
		int [] number5 = {1};
		System.out.println("输入的数组只包含一个数字：");
		of141.reOrderOddEven(number5);
	}
}
