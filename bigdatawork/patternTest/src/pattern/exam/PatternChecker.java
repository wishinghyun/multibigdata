package pattern.exam;


import java.util.regex.Pattern;
 
/** 문자열의 형식을 검사하는 기능을 갖는 클래스 */
public class PatternChecker {
     
    /** 숫자 모양에 대한 형식 검사 */
    public static boolean isNum(String str) {
   return Pattern.matches("[0-9]+", str);
    }
     
   //** 영문으로만 구성되었는지에 대한 형식 검사 *//*
    public static boolean isEng(String str) {
   return Pattern.matches("[A-z ]+", str);

    }
   //** 한글로만 구성되었는지에 대한 형식 검사 *//*
    public static boolean isKor(String str) {
    	return Pattern.matches("[가-힣ㄱ-ㅎ ]+", str);
    }
     
    //** 영문과 숫자로만 구성되었는지에 대한 형식 검사 *//*
    public static boolean isEngNum(String str) {
    	return Pattern.matches("[\\w ]+", str);
    }
     
    //** 한글과 숫자로만 구성되었는지에 대한 형식 검사 *//*
    public static boolean isKorNum(String str) {
    	return Pattern.matches("[ㄱ-ㅎ가-힣0-9 ]+", str);
    }
     
   //** 이메일 형식인지에 대한 검사 --> "아이디@도메인"의 형식을 충족해야 한다. *//*
    public static boolean isEmail(String str) {
    	return Pattern.matches("^[A-z0-9]+@[A-z0-9]+\\.[A-z]+$", str);
    }
 


    /*public static boolean isIP(String str) {
       
    }*/
    /*public static boolean isEmail2(String str) {
   
    }*/


    public static void main(String[] args){
    	System.out.println("*********isNum********");
    	System.out.println(isNum("2345"));//true
    	System.out.println(isNum("2345한글"));//false
    	System.out.println(isNum("2345****"));//false
    	System.out.println("*********isEng********");
    	System.out.println(isEng("aasdfgasdf"));//true
    	System.out.println(isEng("aasdfgas df"));//true
    	System.out.println(isEng("aasdfgas**df"));//false
    	System.out.println(isEng("aasdfgas1221df"));//false
    	System.out.println(isEng("aasdfgas한글df"));//false
    	System.out.println("***********isKor테스트*************");
    	System.out.println(isKor("aasdfgas한글df"));//false
    	System.out.println(isKor(" 한글"));//true
    	System.out.println(isKor("한글 한긆 ㄴㅇㄻㅁㄹ"));//true
    	System.out.println(isKor("123한글"));//false
    	
    	System.out.println("***********isEngNum테스트*************");
    	System.out.println(isEngNum("aasdfgas한글df"));//false
    	System.out.println(isEngNum(" 한글"));//false
    	System.out.println(isEngNum("   111   asdfa"));//true
    	System.out.println(isEngNum("dfgad998"));//true
    	  	System.out.println("***********isKorNum테스트*************");
    	System.out.println(isKorNum("aasdfgas한글df"));//false
    	System.out.println(isKorNum(" 한글"));//true
    	System.out.println(isKorNum("   111   asdfa"));//false
    	System.out.println(isKorNum("한글998"));//true

    	/*System.out.println(isCellPhone("010-718-8634"));//true
    	System.out.println(isCellPhone("011-222-8634"));//true
    	System.out.println(isTel("02-631-8634"));//true
    	System.out.println(isTel("03-33631-8634"));//false
    	System.out.println(isTel("0333-631-8634"));//false*/
    	System.out.println("***********Email테스트*************");
    	System.out.println(isEmail("heaves@hanmail.net"));//true
    	System.out.println(isEmail("heaveshanmail.net"));//false
    	
    
    	
    }
}
