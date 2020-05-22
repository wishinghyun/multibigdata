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
			System.out.println("접속성공...");
	        if (socket != null) {
	        	System.out.println("널이아니다.");
	        	//접속한 후에 클라이언트의 아이디를 생성합니다.
	            ioWork();
	        }
	        Thread t1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while (true) {
	                    String msg;
	                    try {
	                        msg = br.readLine();
	                        System.out.println("서버로 부터 수신된 메시지>>"
	                                + msg);
	                    } catch (IOException e) {
	                        try {
	                            //2. 서버쪽에서 연결이 끊어지는 경우 사용자는 자원을 반납======
	                            //자원반납
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
	                        break;//반복문 빠져나가도록 설정
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
	        //여기서 클라이언트의 아이디를 서버에게 전송합니다.
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	}
	public static void main(String[] args) {
		new CarClient();
	}
}
