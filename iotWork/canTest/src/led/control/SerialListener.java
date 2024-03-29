package led.control;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import serial.SerialConnect;
//시리얼포트를 통해서 데이터가 전송되었을때 실행되는 클래스
public class SerialListener implements SerialPortEventListener{
	BufferedInputStream bis; //캔통신으로 input되는 데이터를 읽기 위해 오픈된 스트림객체
	SerialConnect arduinoConnect;//아두이노와 시리얼통신을 위한 객체
	OutputStream os;//아두이노로 시리얼출력을 위해 작업
	public SerialListener(BufferedInputStream bis) {
		this.bis = bis;
		arduinoConnect = new SerialConnect();//아두이노의 output스트림 얻는 작업!
		arduinoConnect.connect("COM5", "arduino");
		os = arduinoConnect.getOut();//여기까지
	}
	//데이터가 전송될때마다 호출되는 메소드
	@Override
	public void serialEvent(SerialPortEvent event) {
		switch(event.getEventType()) {
			case SerialPortEvent.DATA_AVAILABLE:
				byte[] readBuffer = new byte[128];
			try {
				while(bis.available()>0) {
					int numbyte = bis.read(readBuffer);
				}
				String data = new String(readBuffer);
				System.out.println("Can시리얼포트로 전송된 데이터 ==> "+data);
				//전송되는 메시지를 검사해서 적절하게 다른 장치를 제어하거나
				//CAR클라이언트 객체로 전달해서 서버로 전송되도록 처리!!!!!!!!!!!!!!!!!!!여기에
				
				//캔으로 수신된 데이터가 0000000000000011면 LED끄기
				//캔으로 수신된 데이터가 0000000000000000면 LED켜기
				/*
				 * 1. 아두이노와 시리얼통신할 수 있도록 output스트림 얻기
				 *    => 생성자에서 한 번 작업할 수 있도록 처리
				 * 2. output스트림으로 '0','1'내보내기
				 *    => CAN으로 수신된 데이터를 비교해서 
				 */
				if (os!=null) {
					if (data.trim().equals(":U280000000000000000000000003F")) {
						os.write('1');
					}else {
						os.write('0');
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
