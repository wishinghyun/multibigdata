package android.control;
//안드로이드(클라이언트)의 요청을 받으면 차 안에서 장치와 통신하는 시리얼통신객체 쪽으로 요청을 전달하는 서버
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import basic.SerialArduinoLEDTest;

public class AndroidLEDControlServer {
	private ServerSocket server;
	
	
	public void connect() {
		try {
			server = new ServerSocket(12345);
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread th = new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Socket client = server.accept();
						String ip = client.getInetAddress().getHostAddress();
						System.out.println(ip+"사용자접속!!\n");
						//클라이언트가 보내는 메시지를 읽고 있는 쓰레드
						new ReceiverThread(client).start();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		th.start();
	}
	public static void main(String[] args) {
		new AndroidLEDControlServer().connect();
	}

}
