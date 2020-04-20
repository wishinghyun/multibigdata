package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int progressVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.text1);
    }
    public void btnNoThread(View view){
        for (progressVal=1;progressVal<100;progressVal++){
            progressBar.setProgress(progressVal);
            SystemClock.sleep(1000); //1초동안 멈춰있는 효과
        }
    }
}
