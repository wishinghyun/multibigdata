package can.basic;

import java.io.IOException;
import java.io.OutputStream;
import java.util.TooManyListenersException;

import gnu.io.SerialPort;
import serial.SerialConnect;
/*
 * CAN����� ���� ó��
 * 1. ���Ž����ϱ� - �����͸� ������ �غ� �Ǿ����� ����
 * 2. ������ �����ϱ�
 * 3. ������ �۽��ϱ�
 */
//ĵ��Ÿ� ���
public class CANConnect {
	SerialConnect serialConnect;//CAN�ø�����Ʈ ����
	OutputStream out;//CAN�� output����� ��Ʈ��
	public CANConnect(String portName) {
		//�ø�������� ���� ����
		serialConnect = new SerialConnect();
		serialConnect.connect(portName, this.getClass().getName());
		
		//input, output�۾��� �ϱ� ���� �����ʸ� port�� ����
		SerialPort commPort = (SerialPort)serialConnect.getCommPort();
		SerialListener listener = new SerialListener(serialConnect.getBis());
		try {
			commPort.addEventListener(listener);
			commPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
		//output��Ʈ�� ���
		out = serialConnect.getOut();
		
		//�����尡 ����� �� �ֵ���
		new Thread(new CanSerialWrite()).start();
		System.out.println("ĵ ����� ���۵Ǿ����ϴ�...");
	}
	//CAN����� �ϱ� ���� ������ - CAN��� output����� �ϴ� ������
	class CanSerialWrite implements Runnable{
		String data; //CAN���� ������ ������
		public CanSerialWrite() {
			//1. CAN����� �� �� �ִ� ���¶�� ���� �˷��ֱ� - CAN������ ����
			//�Ŀ�����Ʈ can���Ȱ���� 12p����!
			//check sum�� ���� ������ ���ؾߵ�!���������� ���� ��
			this.data =":G11A9\r";//���Ž��ۿ� ���õ� ������ ������
		}
		@Override
		public void run() {
			byte[] outputdata = data.getBytes();
			try {
				out.write(outputdata);//�� ���Ż��¾�!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new CANConnect("COM9");
	}
}