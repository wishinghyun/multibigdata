package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class CarClient {
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;
    Socket socket;
    OutputStream os;
    PrintWriter pw;
    String carId;
    int flag;
	public CarClient() {
		connect();
		
	}
	public void connect() {
		try {
			socket = new Socket("70.12.224.58", 12345);
			System.out.println("���Ӽ���...");
	        if (socket != null) {
	        	System.out.println("���̾ƴϴ�.");
	        	//������ �Ŀ� Ŭ���̾�Ʈ�� ���̵� �����մϴ�.
	            ioWork();
	        }
	        Thread t1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while (true) {
	                    String msg;
	                    try {
	                        msg = br.readLine();
	                        System.out.println("������ ���� ���ŵ� �޽���>>"
	                                + msg);
	                    } catch (IOException e) {
	                        try {
	                            //2. �����ʿ��� ������ �������� ��� ����ڴ� �ڿ��� �ݳ�======
	                            //�ڿ��ݳ�
	                            is.close();
	                            isr.close();
	                            br.close();
	                            os.close();
	                            pw.close();
	                            socket.close();
	                          
	
	                        } catch (IOException e1) {
	                            // TODO Auto-generated catch block
	                            e1.printStackTrace();
	                        }
	                        break;//�ݺ��� ������������ ����
	                    }
	                }
	            }
	        });
	        t1.start();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
   	}
	void ioWork(){
	    try {
	        is = socket.getInputStream();
	        isr = new InputStreamReader(is);
	        br = new BufferedReader(isr);

	        os = socket.getOutputStream();
	        pw = new PrintWriter(os,true);
	        //���⼭ Ŭ���̾�Ʈ�� ���̵� �������� �����մϴ�.
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	}
	public static void main(String[] args) {
		new CarClient();
	}
}
