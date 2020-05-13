package multi.android.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import multi.android.network.R;

public class MainActivity extends AppCompatActivity {
    TextView clientInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clientInfo = findViewById(R.id.textInfo);
    }
    public void btn_connect(View v){
       new NetworkClient().start();
    }
    class NetworkClient extends Thread{
        @Override
        public void run() {
            Socket socket;
            InputStream is = null;
            DataInputStream dis = null;
            OutputStream os = null;
            DataOutputStream dos = null;
            try {
                socket = new Socket("70.12.116.53", 12345);
                System.out.println("서버접속완료..."+socket);

                is = socket.getInputStream();
                dis = new DataInputStream(is);

                os = socket.getOutputStream();
                dos = new DataOutputStream(os);

                //1. 클라이언트 <-서버(서버가 보내는 데이터를 읽기 - 2번 연속해서 읽기)
                final String data = dis.readUTF();
                Log.d("mynetwork","서버가 전송하는 메시지1:"+data);
                final int intdata = dis.readInt();
                Log.d("mynetwork","서버가 전송하는 메시지2:"+intdata);

                //2. 클라이언트 -> 서버
                dos.writeUTF("안녕하세요 서버님 클라이언트입니다.");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        clientInfo.append(data+"\n");
                        clientInfo.append(intdata+"");
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
