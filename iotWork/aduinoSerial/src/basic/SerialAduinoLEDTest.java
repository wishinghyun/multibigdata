package basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class SerialAduinoLEDTest {
	public SerialAduinoLEDTest() {
		
	}
	public void connect(String portName) {
		try {
			//COM��Ʈ�� ���� �����ϰ� ��� ������ �������� Ȯ��
			CommPortIdentifier commPortIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			if(commPortIdentifier.isCurrentlyOwned()) {//��Ʈ�� ��������� üũ
				System.out.println("��Ʈ ����� �� �����ϴ�.");
			}else {
				System.out.println("��Ʈ ��밡��");
				//port�� ��� �����ϸ� ��Ʈ�� ���� ��Ʈ��ü�� ������
				//�Ű�����1 : ��Ʈ�� ���� ����ϴ� ���α׷��� �̸�(���ڿ�)
				//�Ű�����2 : ��Ʈ�� ���� ����ϱ� ���ؼ� ��ٸ��� �ð�(�и�������)
					CommPort commPort = commPortIdentifier.open("basic_serial",5000);
					//System.out.println(commPort);
					if(commPort instanceof SerialPort) {
						System.out.println("SerialPort");
						//��ſ� �ʿ��� ������ �����Ϸ��� ĳ����
						SerialPort serialPort = (SerialPort)commPort;
						//SerialPort�� ���� ����
						serialPort.setSerialPortParams(9600,
														SerialPort.DATABITS_8,
														SerialPort.STOPBITS_1,
														SerialPort.PARITY_NONE);
						InputStream in = serialPort.getInputStream();
						OutputStream out = serialPort.getOutputStream();
						//�����͸� �ְ� �޴� �۾�(������)�� ���⿡ ȣ��
						//�ȵ���̵忡�� �Է¹��� ���� �Ƶ��̳�� �����ϴ� ������
						new TCPServer(out).start();
					}else {
						System.out.println("SerialPort�� �۾��� �� �ֽ��ϴ�");
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
	public static void main(String[] args) {
		new SerialAduinoLEDTest().connect("COM5");
	}
}
