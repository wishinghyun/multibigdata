package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UseOtherApp extends AppCompatActivity {
    public static final int SELECT_VIEW = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_other_test);
    }

    public void callActivity(View view){
        //다른 앱의 엑티비티를 호출
        //암시적 인텐트 - 정확하게 실행할 액티비티명을 모르는 경우
        Intent intent = new Intent("com.exam.selectview");
        startActivityForResult(intent,SELECT_VIEW);
    }
}
