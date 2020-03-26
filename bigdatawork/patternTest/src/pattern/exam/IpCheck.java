package pattern.exam;

import java.util.regex.Pattern;

/*
 *  0~255까지 네자리
 *  250이상
 *  200-249
 *  100-199
 *  0-99
 *  IpCheck -> ip타입으로 적절한지 체크
 *  Password체크
 *  	-> 8글자이상,대문자,소문자,특수문자,숫자가 모두 포함
 *  	   pattern연습하면서 작업했던 코드 rename
 *  (?=.*[A-Z]){1,}(?=.*[a-z]){1,}(?=.*\\d){1,}(?=.*[!@#$%^&*]){1,}.{8,}$
 */

public class IpCheck {
	public static boolean isIP(String str) {
		String ipreg="^([0-9]{1,2}|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])(\\.[0-9]{1,2}|\\.[1][0-9][0-9]|\\.[2][0-4][0-9]|\\.[25][0-5]){3}";
		return Pattern.matches(ipreg, str);
	}
	public static void main(String[] args) {
		System.out.println(isIP("127.0.0.1"));//true
    	System.out.println(isIP("196.168.59.101"));//true
    	System.out.println(isIP("250.0.8.9"));//true
    	System.out.println(isIP("196.168.59"));//false
    	System.out.println(isIP("300.168.59.101"));//false
    	System.out.println(isIP("300.168.592332.101"));//false
    	System.out.println(isIP("300.168.592.문자열"));//false

	}

}
