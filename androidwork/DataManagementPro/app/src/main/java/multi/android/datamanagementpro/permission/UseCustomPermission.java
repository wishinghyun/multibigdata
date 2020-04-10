package multi.android.datamanagementpro.permission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.datamanagementpro.R;

public class UseCustomPermission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useApp(v);
            }
        });
    }
    public void useApp(View v){
        Intent intent = new Intent("com.exam.selectview");
        startActivity(intent);
    }
}
