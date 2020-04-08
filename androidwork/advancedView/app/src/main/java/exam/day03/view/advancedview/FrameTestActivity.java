package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FrameTestActivity extends AppCompatActivity {
    EditText logid;
    EditText logpass;
    EditText signname;
    EditText signid;
    EditText signpass;
    TextView signinfo;
    LinearLayout llogin;
    LinearLayout lsignin;
    LinearLayout lmoreinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_test);


        logid = findViewById(R.id.loginid);
        logpass = findViewById(R.id.loginpass);
        signname = findViewById(R.id.signinname);
        signid = findViewById(R.id.signinid);
        signpass = findViewById(R.id.signinpass);
        Button signin = findViewById(R.id.btnsignin);
        llogin = findViewById(R.id.linearlogin);
        lsignin = findViewById(R.id.linearsignin);
        lmoreinfo = findViewById(R.id.linearmoreinfo);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = signname+"\n"+signid+"\n"+signpass;
                signinfo.setText(str);

            }
        });

    }
    //Button이 클릭될때 호출되는 메소드 = View.OnClickListener의 public void onClick과 동일
    public void myclick(View v){
        if(v.getId()==R.id.login){
            llogin.setVisibility(View.VISIBLE);
            lsignin.setVisibility(View.INVISIBLE);
            lmoreinfo.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.signin){
            llogin.setVisibility(View.INVISIBLE);
            lsignin.setVisibility(View.VISIBLE);
            lmoreinfo.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.moreinfo){
            llogin.setVisibility(View.INVISIBLE);
            lsignin.setVisibility(View.INVISIBLE);
            lmoreinfo.setVisibility(View.VISIBLE);
        }
    }

}
