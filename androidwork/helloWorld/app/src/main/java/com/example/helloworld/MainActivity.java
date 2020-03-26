package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
//Activity의 LifeCycle
public class MainActivity extends AppCompatActivity {
    //onCreate는 Activity가 생성될때 자동으로 호출 - (액티비티가 실행 : 1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("onCreate호출~~~");
        Log.d("test","onCreate()호출~~~");
        setContentView(R.layout.activity_main);
    }

    //onCreate다음으로 호출되는 메소드
    // - (액티비티가 실행 : 2 단, pause상태에서 빠져나올때는 onCreate가 아니라 onStart부터 호출)
    //일시정지 상태에서 빠져나올때 호출
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","onStart()호출");
    }
    //onStart 다음으로 호출되는 메소드 (액티비티가 실행 : 3)
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume()호출");
    }
    //일시정지 상태로 바뀔때 호출되는 메소드
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause()호출");
    }
    //일시정지나 종료 상태로 바뀔때 onPause다음으로 호출되는 메소드
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop()호출");
    }
    //앱이 종료될때 호출되는 메소드
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy()호출");
    }

    //버튼을 클릭했을때 실행할 메소드를 정의
    //메소드의 매개변수에 실행할 버튼을 정의
    //Button의 상위인 View타입으로 정의
    public void myclickMethod(View v){
        Toast.makeText(this,
                "확인버튼이 눌려졌습니다.",
                Toast.LENGTH_LONG).show();
    }
}
