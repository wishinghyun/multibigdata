package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class RunOnUiThreadTest extends AppCompatActivity {
    TextView view1;
    TextView view2;
    boolean isRunning = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_test);
        view1 = findViewById(R.id.txtView1);
        view2 = findViewById(R.id.txtView2);

        new MyThread().start();

    }
    public void btn_click(View view){
        long now_time = System.currentTimeMillis();
        view1.setText(now_time+"");
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            while (isRunning){
                SystemClock.sleep(1000);
                final long now_time = System.currentTimeMillis();
                Log.d("mythread",now_time+"");

                //화면처리에 대한 작업이 여기서만 사용되는 경우
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        view2.setText("화면에 대한 처리 : "+now_time);
                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}
