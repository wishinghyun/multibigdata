package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class SimpleRecyclerTest extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_test);

        list = findViewById(R.id.list);
        //1. Recycler에 출력할 데이터 준비
        List<SimpleItem> recycler_simple_data = new ArrayList<SimpleItem>();
        for (int i=0;i<10;i++){
            SimpleItem item = new SimpleItem("simple_item"+i);
            recycler_simple_data.add(item);
        }
        //2. Adapter생성 - SimpleItemAdapter.java
        SimpleItemAdapter adapter = new SimpleItemAdapter(this,
                                                          R.layout.simple_item,
                                                          recycler_simple_data);
        //3. Recycler의 레이아웃을 설정
        //   LinearLayout, GridLayout 등
        //   RecyclerView에 설정할 레이아웃객체 생성
            /*LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
            //                                      getApplicationContext()는 this랑 같은거임
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        //GridLayout설정
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        list.setHasFixedSize(true);

        list.setLayoutManager(manager); //Vertical LinearLayout이 셋팅
        //4. Recycler와 Adapter를 연결
        list.setAdapter(adapter);

        //5. 추가적인 요소들을 적용할 수 있다
        //   꾸미기, 애니메이션 등
    }
}
