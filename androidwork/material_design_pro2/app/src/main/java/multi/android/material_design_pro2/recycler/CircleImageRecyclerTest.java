package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        recyclerView = findViewById(R.id.recyclerview);
        List<CircleItem> recycler_circle_data = new ArrayList<CircleItem>();
        recycler_circle_data.add(new CircleItem(R.drawable.lee));
        recycler_circle_data.add(new CircleItem(R.drawable.gong));
        recycler_circle_data.add(new CircleItem(R.drawable.jang));
        recycler_circle_data.add(new CircleItem(R.drawable.jung));
        recycler_circle_data.add(new CircleItem(R.drawable.so));
        RecyclerCircleAdapter adapter = new RecyclerCircleAdapter(this,
                                                                    R.layout.circle_item,
                                                                    recycler_circle_data);
        /*LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);*/
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
