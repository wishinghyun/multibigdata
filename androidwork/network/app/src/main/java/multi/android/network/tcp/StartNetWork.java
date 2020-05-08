package multi.android.network.tcp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import multi.android.network.R;

public class StartNetWork extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_net_work);
    }
    public void btn_tcpChat(View view){
        Intent intent = new Intent(this, ChatClientActivity.class);
        startActivity(intent);
    }
}
