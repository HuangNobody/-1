public class Offer14_2 {
	
	public void reOrder(int [] array){
		if(array == null || array.length == 0)
			return;
		int begin = 0;
		int end = array.length-1;
		while(begin<end){
			while(begin<end && !isEven(array[begin]))
				begin++;
			while(begin<end && isEven(array[end]))
				end--;
			if(begin<end){
				int temp = array[begin];
				array[begin] = array[end];
				array[end] = temp;
			}
		}
		
		//输出调整后的数组元素
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+", ");
		}
		System.out.println();
	}
	
	public boolean isEven(int n){
		return (n&0x1)==0;
	}
	
	public static void main(String[] args) {
		//测试用例1.功能测试
		Offer14_2 of142 = new Offer14_2();
		int [] number1 = {1,2,3,4,5};
		System.out.println("输入数组中的奇数、偶数交替出现：");
		of142.reOrder(number1);
	
		int [] number2 = {2,4,1,5,3};
		System.out.println("输入的数组中所有偶数都出现在奇数前面：");
		of142.reOrder(number2);
		
		int [] number3 = {1,5,3,2,4};
		System.out.println("输入的数组中所有奇数都出现在偶数前面：");
		of142.reOrder(number3);
		
		//特殊输入测试
		int [] number4 = null;
		System.out.println("输入NULL指针：");
		of142.reOrder(number4);
		
		int [] number5 = {1};
		System.out.println("输入的数组只包含一个数字：");
		of142.reOrder(number5);
		
	}
}

