package exam.day03.view.selectview.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ResourceDataListActivity extends AppCompatActivity {
    ListView listView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_test);
        listView = findViewById(R.id.listView1);
        txt = findViewById(R.id.listTxt);
        //리소스로 저장되어 있는 데이터를 ListView에 출력
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this,
                                                 R.array.mylist_data,
                                                 android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //View view매개변수가 목록을 구성하는 하나의 데이터가 출력되는 Row를 구성하는 View
                TextView listTxt = (TextView)view;
                txt.setText(listTxt.getText());
            }
        });
    }
}
