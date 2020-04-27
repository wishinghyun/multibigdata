package multi.android.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HandlerExam2 extends AppCompatActivity {
    int num;
    TextView numView;
    Button button;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //여기가 UI thread임
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        numView = findViewById(R.id.numView);
        handler = new Handler();


    }
    public void btn_click(View view){
        //버튼을 누르면 쓰레드를 start
        new NumThread().start();
    }
    //TextView의 값을 지속적으로 변경하는 쓰레드
    class UIUpdateThread implements Runnable{
        @Override
        public void run() {
            numView.setText(num+"");
        }
    }
    //지속해서 값을 만드는 쓰레드
    //여기가 work thread임 - 나중엔 여기가 네트워크나 DB에서 가져와서 값 세팅할 곳
    class NumThread extends Thread{
        public void run(){
            for (int i=1;i<=10;i++){
                num = i;
                //핸들러에게 UI를 변경하는 쓰레드를 전달하여 요청
                handler.post(new UIUpdateThread());
                SystemClock.sleep(500);
            }
        }
    }
}
