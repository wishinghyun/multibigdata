package multi.android.material_design_pro.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.material_design_pro.R;


public class ActionBarNavi extends AppCompatActivity {
    Button showActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_navi);
        showActivity = findViewById(R.id.showActivity);
        showActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionBarNavi.this,
                        SubActivity.class);
                startActivity(intent);
            }
        });
    }
}
