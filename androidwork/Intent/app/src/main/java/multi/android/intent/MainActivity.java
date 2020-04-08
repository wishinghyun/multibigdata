package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                //intent에 공유할 데이터 저장
                intent.putExtra("info",
                        "첫 번째 액티비티가 넘기는 메시지");
                intent.putExtra("num",10000);

                startActivity(intent);
            }
        });
    }
}
