package can.basic;

import java.io.IOException;
import java.io.OutputStream;
import java.util.TooManyListenersException;

import gnu.io.SerialPort;
import serial.SerialConnect;

public class CANReadWriteTest {
	SerialConnect serialConnect;//CAN�ø�����Ʈ ����
	OutputStream out;//CAN�� output����� ��Ʈ��
	public CANReadWriteTest(String portName) {
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
		
		//ó�� CAN����� ���� �غ� �۾��� �Ҷ��� ���Ű����� �޽����� ������ �ֵ���
		new Thread(new CANWriteThread()).start();
	}//end ������
	
	public void send(String msg) {//�ʿ��ѵ��� ȣ���ؼ� �� �� �ֵ��� ���� ��!
		new Thread(new CANWriteThread(msg)).start();
	}
	
	class CANWriteThread implements Runnable{
		String data; //�۽��� �����͸� ������ ����
		//������ ���� �����ϰ� ������ �����!
		CANWriteThread(){//------------------------ó���� ���� ���� ����
			this.data = ":G11A9\r";
		}
		CANWriteThread(String msg){//--------------�޽��� ���������� ���
			this.data = convert_data(msg); //data�� ���� msg�� ���õ�!
		}
		//msg = msg�� id + ������
		public String convert_data(String msg) {
			msg = msg.toUpperCase();//�޽����� �빮�ڷ� ��ȯ
			msg = "W28"+msg; //�۽ŵ������� ���б�ȣ�� �߰�
			//�����δ� �� �پ�����!
			//msg W28 00000000 0000000000000000
			//�����������ӿ� ���� üũ���� ���� - �յڹ��� ���� �������� ���� �� 0xff�� &����
			char[] data_arr = msg.toCharArray();
			int sum=0;
			for (int i = 0; i < data_arr.length; i++) {
				sum = sum + data_arr[i];
			}
			sum = (sum & 0xff);
			//���� �޽����� ���� �ϼ�
			String result = ":" + //ù ����
							msg + //�޽���
							Integer.toHexString(sum).toUpperCase() +//üũ��
							"\r"; //�� ����
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
		String id = "00000000"; //�۽��� �޽����� ���� id
		String data = "0000000000000011"; //�۽��� ������ (���Ƿ� ��ɸ��� �ٸ��� �ָ� ��!)
		String msg = id+data;
		CANReadWriteTest canObj = new CANReadWriteTest("COM9");
		canObj.send(msg);//�޽��� �����°� ������� ��������� ������!
	}
}
