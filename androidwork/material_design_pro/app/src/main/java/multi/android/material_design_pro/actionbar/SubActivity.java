package multi.android.material_design_pro.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import multi.android.material_design_pro.R;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //안드로이드에서 제공하는 뒤로가기 버튼을 액션바에 추가하기
        //액션바를 얻어오기
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); //화면에 추가하기
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home){//안드로이드 기본제공이라 android에서 가져옴
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
