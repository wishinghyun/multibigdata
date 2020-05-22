package serial;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
//시리얼통신을 담당하는 객체
public class SerialConnect{
	InputStream in;
	BufferedInputStream bis; //read,write는 안됨
	OutputStream out;
	CommPort commPort;
	public void connect(String portName,String appName) {
		try {
			CommPortIdentifier commPortIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			if(commPortIdentifier.isCurrentlyOwned()) {//포트가 사용중인지 체크
				System.out.println("포트 사용할 수 없습니다.");
			}else {
				System.out.println("포트 사용가능");
				commPort = commPortIdentifier.open(appName,5000);
				System.out.println(commPort);
				if(commPort instanceof SerialPort) {
					System.out.println("SerialPort");
					SerialPort serialPort = (SerialPort)commPort;
					serialPort.setSerialPortParams(38400, //속도도 차이가 있으므로 매개변수로 받게 나중에 바꿔야댐
													SerialPort.DATABITS_8,
													SerialPort.STOPBITS_1,
													SerialPort.PARITY_NONE);
					in = serialPort.getInputStream();
					bis = new BufferedInputStream(in);
					out = serialPort.getOutputStream();
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
		}
	}
	public BufferedInputStream getBis() {
		return bis;
	}
	public OutputStream getOut() {
		return out;
	}
	public CommPort getCommPort() {
		return commPort;
	}
	
}//end class
