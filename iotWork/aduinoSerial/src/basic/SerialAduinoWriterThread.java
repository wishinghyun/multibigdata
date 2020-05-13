package basic;
//Ű����� �Է��ϴ� ���� �Ƶ��̳�� �������� ���� ������ - Serial���

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
			while((ledstate = System.in.read())>-1) { //Ű���� �Է��� ������ -1�� ����
				out.write(ledstate);//�Ƶ��̳�� ���������� ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
