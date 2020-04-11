package multi.android.datamanagementpro.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import multi.android.datamanagementpro.R;


public class SharedPreferenceTest extends AppCompatActivity {
    EditText first_edit, secod_edit;
    CheckBox noti;
    Switch siren;
    Button save;
    SharedPreferences setting;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_perference_test);
  
        first_edit = (EditText) findViewById(R.id.first_edit);
        secod_edit = (EditText) findViewById(R.id.secod_edit);
        noti = (CheckBox) findViewById(R.id.check1);
        siren = (Switch) findViewById(R.id.check2);
        save = findViewById(R.id.save);

        //설정정보를 저장할 수 있도록 지원되는 객체 - SharedPreferences
        //설정정보를 내 앱 안에 있는 다른 액티비티와 공유하지 못한다
        //설정정보는 xml파일로 저장 - 액티비티명.xml
        //setting = getPreferences(Context.MODE_PRIVATE);

        //Context.MODE_PRIVATE은 다른 앱과 공유가 안된다
        setting = getSharedPreferences("setting",Context.MODE_PRIVATE);
        editor = setting.edit();

        //설정정보가 저장된 xml에서 값을 읽어와서 초기화
        //defValue : 아무것도 없을 때
        first_edit.setText(setting.getString("first",""));
        secod_edit.setText(setting.getString("second",""));
        noti.setChecked(setting.getBoolean("noti",false));
        siren.setChecked(setting.getBoolean("siren",false));

        //저장하기 버튼을 누르면 설정정보를 저장
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("first",first_edit.getText().toString());
                editor.putString("second",secod_edit.getText().toString());
                editor.putBoolean("noti",noti.isChecked());
                editor.putBoolean("siren",siren.isChecked());
                editor.commit();

                //clear메소드를 이용해서 지우는 것은 전체삭제
                //remove는 editor안의 일부를 지우는 작업
            }
        });
	}
}
