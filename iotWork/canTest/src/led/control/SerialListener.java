package led.control;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import serial.SerialConnect;
//�ø�����Ʈ�� ���ؼ� �����Ͱ� ���۵Ǿ����� ����Ǵ� Ŭ����
public class SerialListener implements SerialPortEventListener{
	BufferedInputStream bis; //ĵ������� input�Ǵ� �����͸� �б� ���� ���µ� ��Ʈ����ü
	SerialConnect arduinoConnect;//�Ƶ��̳�� �ø�������� ���� ��ü
	OutputStream os;//�Ƶ��̳�� �ø�������� ���� �۾�
	public SerialListener(BufferedInputStream bis) {
		this.bis = bis;
		arduinoConnect = new SerialConnect();//�Ƶ��̳��� output��Ʈ�� ��� �۾�!
		arduinoConnect.connect("COM5", "arduino");
		os = arduinoConnect.getOut();//�������
	}
	//�����Ͱ� ���۵ɶ����� ȣ��Ǵ� �޼ҵ�
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
				System.out.println("Can�ø�����Ʈ�� ���۵� ������ ==> "+data);
				//���۵Ǵ� �޽����� �˻��ؼ� �����ϰ� �ٸ� ��ġ�� �����ϰų�
				//CARŬ���̾�Ʈ ��ü�� �����ؼ� ������ ���۵ǵ��� ó��!!!!!!!!!!!!!!!!!!!���⿡
				
				//ĵ���� ���ŵ� �����Ͱ� 0000000000000011�� LED����
				//ĵ���� ���ŵ� �����Ͱ� 0000000000000000�� LED�ѱ�
				/*
				 * 1. �Ƶ��̳�� �ø�������� �� �ֵ��� output��Ʈ�� ���
				 *    => �����ڿ��� �� �� �۾��� �� �ֵ��� ó��
				 * 2. output��Ʈ������ '0','1'��������
				 *    => CAN���� ���ŵ� �����͸� ���ؼ� 
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