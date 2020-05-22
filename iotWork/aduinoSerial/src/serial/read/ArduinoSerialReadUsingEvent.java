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
			if(commPortIdentifier.isCurrentlyOwned()) {//��Ʈ�� ��������� üũ
				System.out.println("��Ʈ ����� �� �����ϴ�.");
			}else {
				System.out.println("��Ʈ ��밡��");
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
						
						//Arduino�� ���ؼ� �ݺ��ؼ� ������ �����͸� ���� �� �ֵ��� �ڵ� �ۼ�
						//�̺�Ʈ�� �����ϵ��� ����
						SerialListener listener = new SerialListener(in);
						serialPort.addEventListener(listener);
						//�ø�����Ʈ�� ���۵Ǿ� ���ƿ��� �����Ͱ� �ִٸ� noti�ϸ� �̺�Ʈ �����ʰ� ����ǵ��� ó��
						serialPort.notifyOnDataAvailable(true);//�����Ͱ� �߻��Ҷ����� ���ΰ�ħ����
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
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
	}
}
