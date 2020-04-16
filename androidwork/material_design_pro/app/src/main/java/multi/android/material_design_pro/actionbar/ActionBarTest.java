package multi.android.material_design_pro.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import multi.android.material_design_pro.R;

public class ActionBarTest extends AppCompatActivity {
    TextView result, result2;
    ListView listview;
    String[] datalist = {"java","servlet","jsp","html","android","spring",
                                    "spark","sqoop","spark","sqoop","spark","sqoop"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);
        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);
        listview = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                                android.R.layout.simple_list_item_1,
                                                                android.R.id.text1,
                                                                datalist);
        listview.setAdapter(adapter);

        //리스트뷰가 검색이 가능하도록 설정
        listview.setTextFilterEnabled(true);//리스트뷰에 있는 목록을 검색해서 사용할 수 있게 해줌
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu,menu);

        //검색뷰가 셋팅되어 있는 메뉴아이템을 추출
        MenuItem search_item = menu.findItem(R.id.search);
        //액션뷰로 설정되어 있는 뷰를 추출한다
        SearchView searchView = (SearchView) search_item.getActionView();
        //안내 문구를 등록
        searchView.setQueryHint("검색어를 입력하세요");

        //이벤트 연결하기
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //키패드의 엔터키를 누르면 호출되는 메소드
            @Override
            public boolean onQueryTextSubmit(String query) {
                result.setText(query);
                return true;
            }
            //searchView의 텍스트가 변경될때 호출
            @Override
            public boolean onQueryTextChange(String newText) {
                result2.setText(newText);
                //전달되는 입력하는 문자열을 이용하여 listView에서 필터링
                listview.setFilterText(newText);
                if (newText.length()==0){
                    listview.clearTextFilter();
                }
                return true;
            }
        });

        //search_item에 이벤트를 연결
        search_item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            //메뉴가 펼쳐질때
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                result.setText("메뉴가 펼쳐짐");
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                result.setText("메뉴가 접혀짐");
                return true;
            }
        });

        return true;
    }
    //액션바의 아이콘, 메뉴가 선택될때
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("menu",item.getItemId()+"");
        int id = item.getItemId();
        String msg = "";
        switch (id){
            case R.id.search:
                msg = "첫 번째 메뉴 선택";
                break;
            case R.id.option_1:
                msg = "즐겨찾기";
        }
        result2.setText(msg);
        return super.onOptionsItemSelected(item);
    }
}
