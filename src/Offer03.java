
public class Offer03 {
	
	public boolean Find(int [][] arrays, int target){
		if(arrays == null){
			return false;
		}
		int row = 0;
		int column = arrays[0].length-1;
		
		while(row<arrays.length && column>=0){
			if(arrays[row][column] == target){
				return true;
			}else if(arrays[row][column]>target){
				column--;
			}else{
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]arrays = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		Offer03 of03 = new Offer03();
		//测试用例
		//1，二维数组中包含查找的数字（查找的数组是数组中的最大值和最小值，查找的数字介于数组中的最大值和最小值之间）
		int target1 = 15;
		int target2 = 1;
		int target3 = 7;
		System.out.println(of03.Find(arrays, target1));
		System.out.println(of03.Find(arrays, target2));
		System.out.println(of03.Find(arrays, target3));
		
		//2，二维数组中没有查找的数字（查找的数字大于数组中的最大值，查找的数字小于数组中的最小值，
		//查找的数字在数组的最大值和最小值之间但是数组中没有这个数字）
		int target4 = 16;
		int target5 = 0;
		int target6 = 3;
		System.out.println(of03.Find(arrays, target4));
		System.out.println(of03.Find(arrays, target5));
		System.out.println(of03.Find(arrays, target6));
		
		//3，特殊输入测试（输入空指针）
		int target7 = 7;
		int [][] arrays_2 = null;
		System.out.println(of03.Find(arrays_2, target7));
	}
}
