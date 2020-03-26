package pattern.exam;

public class EmailCheck {
	public static void main(String[] args) {
		//x{n}=>x를 n번 반복한 문자를 찾는다는 의미로 해석
		//이메일 패턴을 정의		결과 : f t f t f f t
		String emailReg="^[A-z]+\\.?[A-z0-9]+@[A-z]+(\\.[a-zA-Z]+){1,2}$"; 
		String[] user = {"heaves@hanmail,net","heaves@hanmail.net",
					"테스트heaves@hanmail.net","sc.com@hanmail.net",
					",heaves@hanmail.net","@hanmail.net"
					,"heaves@hanmail.co.kr"};
		//user에 입력된 email의 형식이 맞는지 true|false로 출력할 수 있도록 작업	
		//boolean result;
		for(int i=0;i<=user.length-1;i++) {
			//result = Pattern.matches(emailReg, user[i]);
			System.out.println(user[i]+" : "+user[i].matches(emailReg));
			
		}
	}

}
