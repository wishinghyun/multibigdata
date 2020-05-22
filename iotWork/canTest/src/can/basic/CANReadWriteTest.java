package can.basic;

import java.io.IOException;
import java.io.OutputStream;
import java.util.TooManyListenersException;

import gnu.io.SerialPort;
import serial.SerialConnect;

public class CANReadWriteTest {
	SerialConnect serialConnect;//CAN시리얼포트 연결
	OutputStream out;//CAN과 output통신할 스트림
	public CANReadWriteTest(String portName) {
		serialConnect = new SerialConnect();
		serialConnect.connect(portName, this.getClass().getName());
		
		//input, output작업을 하기 위해 리스너를 port에 연결
		SerialPort commPort = (SerialPort)serialConnect.getCommPort();
		SerialListener listener = new SerialListener(serialConnect.getBis());
		try {
			commPort.addEventListener(listener);
			commPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
		//output스트림 얻기
		out = serialConnect.getOut();
		
		//처음 CAN통신을 위한 준비 작업을 할때는 수신가능한 메시지를 보낼수 있도록
		new Thread(new CANWriteThread()).start();
	}//end 생성자
	
	public void send(String msg) {//필요한데서 호출해서 쓸 수 있도록 따로 뺌!
		new Thread(new CANWriteThread(msg)).start();
	}
	
	class CANWriteThread implements Runnable{
		String data; //송신할 데이터를 저장할 변수
		//쓰레드 수신 가능하게 생성자 만들기!
		CANWriteThread(){//------------------------처음에 수신 가능 설정
			this.data = ":G11A9\r";
		}
		CANWriteThread(String msg){//--------------메시지 보낼때마다 사용
			this.data = convert_data(msg); //data에 보낼 msg가 셋팅됨!
		}
		//msg = msg의 id + 데이터
		public String convert_data(String msg) {
			msg = msg.toUpperCase();//메시지를 대문자로 변환
			msg = "W28"+msg; //송신데이터의 구분기호를 추가
			//실제로는 다 붙어있음!
			//msg W28 00000000 0000000000000000
			//데이터프레임에 대한 체크섬을 생성 - 앞뒤문자 빼고 나머지를 더한 후 0xff로 &연산
			char[] data_arr = msg.toCharArray();
			int sum=0;
			for (int i = 0; i < data_arr.length; i++) {
				sum = sum + data_arr[i];
			}
			sum = (sum & 0xff);
			//보낼 메시지를 최종 완성
			String result = ":" + //첫 문자
							msg + //메시지
							Integer.toHexString(sum).toUpperCase() +//체크섬
							"\r"; //끝 문자
			return result;
		}
		@Override
		public void run() {
			byte[] outputdata = data.getBytes();
			try {
				out.write(outputdata);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		String id = "00000000"; //송신할 메시지의 구분 id
		String data = "0000000000000011"; //송신할 데이터 (임의로 기능마다 다르게 주면 됨!)
		String msg = id+data;
		CANReadWriteTest canObj = new CANReadWriteTest("COM9");
		canObj.send(msg);//메시지 보내는게 쓰레드로 만들어져서 보내짐!
	}
}
