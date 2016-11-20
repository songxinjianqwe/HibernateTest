package util;
/**
 * 
 * @author songx
	<0 ~ 500  1
	500       2
	1500      3
	3000      4
	>5000      5
 */
public class VIPLevel {
	
	public static int getLevel(int credit){
		if(credit < 500){
			return 1;
		}else if(credit < 1500){
			return 2;
		}else if(credit < 3000){
			return 3;
		}else if(credit < 5000){
			return 4;
		}else{
			return 5;
		}
	}
}

