package exam.day03.view.selectview.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import exam.day03.view.selectview.R;

public class AddViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        //Layout만들기 - width,height지정
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        //Layout에 추가할 view를 생성 - 상위뷰의 크기 정보를 갖고 있는 LayoutParams를 설정
        Button btn = new Button(this);
        btn.setText("코드로 만들어진 버튼");
        btn.setLayoutParams(params);

        //Layout에 뷰를 추가
        layout.addView(btn);

        //Activity에 layout 설정
        setContentView(layout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn2 = new Button(AddViewTestActivity.this);
                btn2.setText("이벤트로 만들어진 객체");
                layout.addView(btn2);
            }
        });
    }
}
