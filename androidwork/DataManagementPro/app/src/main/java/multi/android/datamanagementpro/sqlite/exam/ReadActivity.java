package multi.android.datamanagementpro.sqlite.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import multi.android.datamanagementpro.R;


public class ReadActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		Intent intent = getIntent();
		Bundle data = intent.getExtras();
		TextView t = (TextView)findViewById(R.id.show);

		String id = intent.getStringExtra("id");
		String name = intent.getStringExtra("name");
		String price = intent.getStringExtra("price");

		t.setText(id+","+name+","+price);
	}

}
