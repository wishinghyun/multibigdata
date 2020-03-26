package exam.day01.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void check(View v){
        Toast.makeText(this,
                "확인버튼이 눌려졌습니다.",
                Toast.LENGTH_LONG).show();
    }
    public void cancel(View v){
        Toast.makeText(this,
                "취소버튼이 눌려졌습니다.",
                Toast.LENGTH_SHORT).show();
    }
    public void del(View v){
        Toast.makeText(this,
                "삭제버튼이 눌려졌습니다.",
                Toast.LENGTH_LONG).show();
    }
}
