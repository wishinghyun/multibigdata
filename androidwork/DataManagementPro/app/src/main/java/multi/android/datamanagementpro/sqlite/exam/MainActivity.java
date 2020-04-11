package multi.android.datamanagementpro.sqlite.exam;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import multi.android.datamanagementpro.R;


public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {
	DBHandler handler;
	EditText edtName;
	EditText edtSu;
	EditText edtPrice;
	ListView listview;
	public static final int DATA_INTENT = 0;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		handler = DBHandler.open(this);

		findViewById(R.id.btnIns).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);
		listview = findViewById(R.id.list);
		listview.setOnItemClickListener(this);

		edtName = (EditText)findViewById(R.id.edtName);
		edtSu = (EditText)findViewById(R.id.edtSu);
		edtPrice = (EditText)findViewById(R.id.edtPrice);

	}


	@Override
	public void onClick(View v) {
		//DBHandler dbHandler = DBHandler.open(this);
		if (v.getId()==R.id.btnIns){
			handler.insert(edtName.getText().toString(),
					edtPrice.getText().toString(),
					edtSu.getText().toString());
		}else if (v.getId()==R.id.btnResult){
			Cursor cursor = handler.selectAll();
			ArrayList<String> arrayList = new ArrayList<String>();
			while (cursor.moveToNext()){
				String idx = Integer.toString(cursor.getInt(0));
				String name = cursor.getString(1);
				String price = cursor.getString(2);
				String su = cursor.getString(3);
				String totPrice = cursor.getString(4);
				arrayList.add(idx+","+name+","+price+","+su+","+totPrice);
			}
			ArrayAdapter adapter = new ArrayAdapter(this,
					android.R.layout.simple_list_item_1,
					arrayList);
			listview.setAdapter(adapter);
		}else if (v.getId()==R.id.btnResult2){
			Cursor cursor = handler.selectAll();
			ArrayList<String> arrayList = new ArrayList<String>();
			while (cursor.moveToNext()){
				String name = cursor.getString(1);
				String price = cursor.getString(2);
				arrayList.add(name+"\n"+price);
			}
			ArrayAdapter adapter = new ArrayAdapter(this,
					android.R.layout.simple_list_item_1,
					arrayList);
			listview.setAdapter(adapter);
		}else if (v.getId()==R.id.btnSearch){
			Cursor cursor = handler.search(edtName.getText().toString());
			ArrayList<String> arrayList = new ArrayList<String>();
			while (cursor.moveToNext()){
				String name = cursor.getString(1);
				String price = cursor.getString(2);
				arrayList.add(name+"\n"+price);
			}
			ArrayAdapter adapter = new ArrayAdapter(this,
					android.R.layout.simple_list_item_1,
					arrayList);
			listview.setAdapter(adapter);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String[] strings = parent.getItemAtPosition(position).toString().split(",");

		Intent intent = new Intent(MainActivity.this,ReadActivity.class);
		intent.putExtra("id",strings[0]);
		intent.putExtra("name",strings[1]);
		intent.putExtra("price",strings[2]);
		startActivityForResult(intent,DATA_INTENT);
	}
}



















