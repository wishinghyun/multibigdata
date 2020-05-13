package multi.android.network.aduino;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import multi.android.network.R;

public class LedTest extends AppCompatActivity implements View.OnClickListener {
    Button btnOn, btnOff;
    Socket socket;
    PrintWriter pw;
    OutputStream out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_test);
        btnOn = findViewById(R.id.btnOn);
        btnOn.setOnClickListener(this);
        btnOff = findViewById(R.id.btnOff);
        btnOff.setOnClickListener(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("70.12.229.78",5000);
                    if(socket!=null){
                        try {
                            out = socket.getOutputStream();
                            pw = new PrintWriter(out, true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnOn){
            sendMessage(1);
        }else if(v.getId()==R.id.btnOff){
            sendMessage(0);
        }
    }

    public void sendMessage(final int message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                pw.println(message);
                pw.flush();
            }
        }).start();
    }


}
