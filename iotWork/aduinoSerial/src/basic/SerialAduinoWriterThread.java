package basic;
//키보드로 입력하는 값을 아두이노로 내보내기 위한 쓰레드 - Serial통신

import java.io.IOException;
import java.io.OutputStream;

public class SerialAduinoWriterThread extends Thread{
	OutputStream out;
	
	public SerialAduinoWriterThread(OutputStream out) {
		super();
		this.out = out;
	}

	@Override
	public void run() {
		super.run();
		int ledstate = 0;
		try {
			while((ledstate = System.in.read())>-1) { //키보드 입력이 없으면 -1을 리턴
				out.write(ledstate);//아두이노로 지속적으로 들어감
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
