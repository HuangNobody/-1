
public class Offer_04 {
	public String replaceSpace(String str){
		if(str == null||str.length()<=0)//str == null判断字符串是个null指针，str.length()<=0判断字符串是空字符串
			return null;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<str.length();i++){
			if(String.valueOf(str.charAt(i)).equals(" ")){//String.valueOf（）：Returns the string representation of the char argument.
				sb.append("%20");
			}else{
				sb.append(str.charAt(i));
			}
		}
		return String.valueOf(sb);
	}
	public static void main(String[] args) {
		Offer_04 of4 = new Offer_04();

		//测试用例
		//1，输入的字符串中包含空格（空格位于字符串的最前面，空格位于字符串的最后面，空格位于字符串的中间，字符串中有连续多个空格）。
		String str1 = " We are happy.";
		System.out.println(of4.replaceSpace(str1));
		String str2 = "We are happy. ";
		System.out.println(of4.replaceSpace(str2));
		String str3 = "We  are happy.";
		System.out.println(of4.replaceSpace(str3));
		
		//2，输入的字符串中没有空格
		String str4 = "Wearehappy.";
		System.out.println(of4.replaceSpace(str4));
		
		//特殊输入测试（字符串是个null指针 、字符串是个空字符串、字符串只有一个空格字符、字符串只有连续多个空格）。
		String str5 = null;
		System.out.println(of4.replaceSpace(str5));
		
		String str6 = "";//""表示空字符串
		System.out.println(of4.replaceSpace(str6));
		String str7 = " ";//" "表示一个空格字符
		System.out.println(of4.replaceSpace(str7));
		String str8 = "   ";//" "表示3个空格字符
		System.out.println(of4.replaceSpace(str8));
		
	}
}
/**
 * StringBuilder a = new StringBuilder("we are happy.");
 * String b = " " + a;//将StringBuilder类型转换成String类型
 * StringBuilder a = new StringBuilder(a);//将String类型转换为StringBuilder类型
 * */
