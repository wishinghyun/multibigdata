package multi.android.material_design_pro2.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;
import multi.android.material_design_pro2.recycler.CircleItem;

public class CardViewListExam extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_list_exam);

        list = findViewById(R.id.cardlist);
        List<CardImgTxtItem> item_list = new ArrayList<CardImgTxtItem>();
        item_list.add(new CardImgTxtItem(R.drawable.lee,"이민호의 신의"));
        item_list.add(new CardImgTxtItem(R.drawable.gong,"공유의 도깨비"));
        item_list.add(new CardImgTxtItem(R.drawable.jung,"정우성의 비트"));
        item_list.add(new CardImgTxtItem(R.drawable.jang,"검색어를 입력하세요"));
        item_list.add(new CardImgTxtItem(R.drawable.so,"미안하다 사랑한다"));
        CardListAdapter adapter = new CardListAdapter(this,
                                                      R.layout.card_view_item,
                                                      item_list);
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),1);
        list.setHasFixedSize(true);
        list.setLayoutManager(manager);
        list.setAdapter(adapter);
    }
}
