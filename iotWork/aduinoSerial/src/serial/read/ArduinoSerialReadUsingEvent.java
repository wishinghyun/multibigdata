package serial.read;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;

import basic.SerialArduinoWriterThread;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class ArduinoSerialReadUsingEvent {
	public static void main(String[] args) {
		try {
			CommPortIdentifier commPortIdentifier = CommPortIdentifier.getPortIdentifier("COM5");
			if(commPortIdentifier.isCurrentlyOwned()) {//포트가 사용중인지 체크
				System.out.println("포트 사용할 수 없습니다.");
			}else {
				System.out.println("포트 사용가능");
					CommPort commPort = commPortIdentifier.open("basic_serial",5000);
					if(commPort instanceof SerialPort) {
						System.out.println("SerialPort");
						SerialPort serialPort = (SerialPort)commPort;
						serialPort.setSerialPortParams(9600,
														SerialPort.DATABITS_8,
														SerialPort.STOPBITS_1,
														SerialPort.PARITY_NONE);
						InputStream in = serialPort.getInputStream();
						OutputStream out = serialPort.getOutputStream();
						
						//Arduino를 통해서 반복해서 들어오는 데이터를 읽을 수 있도록 코드 작성
						//이벤트에 반응하도록 연결
						SerialListener listener = new SerialListener(in);
						serialPort.addEventListener(listener);
						//시리얼포트로 전송되어 돌아오는 데이터가 있다면 noti하며 이벤트 리스너가 실행되도록 처리
						serialPort.notifyOnDataAvailable(true);//데이터가 발생할때마다 새로고침해줌
					}else {
						System.out.println("SerialPort만 작업할 수 있습니다");
					}
			}
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
	}
}
