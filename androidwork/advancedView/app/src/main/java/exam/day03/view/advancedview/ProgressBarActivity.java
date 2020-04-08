package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar = findViewById(R.id.progress3);
        btn1 = findViewById(R.id.progressBtn1);
        btn2 = findViewById(R.id.progressBtn2);
        btn3 = findViewById(R.id.progressBtn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1_click();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2_click();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3_click();
            }
        });
    }
    public void btn1_click(){ //5증가
        progressBar.incrementProgressBy(5);
    }
    public void btn2_click(){ //5감소
        progressBar.incrementProgressBy(-5);
    }
    public void btn3_click(){ //값 셋팅
        progressBar.setProgress(80);
    }
}
