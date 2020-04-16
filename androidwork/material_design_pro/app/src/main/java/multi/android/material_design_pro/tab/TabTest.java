package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.ListTestFragment;
import multi.android.material_design_pro.exam.view1Fragment;
import multi.android.material_design_pro.exam.view3Fragment;

public class TabTest extends AppCompatActivity {
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    view1Fragment view1Fragment = new view1Fragment();
    ListTestFragment view2Fragment = new ListTestFragment();
    view3Fragment view3Fragment = new view3Fragment();
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);

        tabLayout = findViewById(R.id.mytab);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //텝 추가
        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        //처음 실행할 때 보여줄 프레그먼트 지정
        getSupportFragmentManager().beginTransaction().
                                        replace(R.id.content_container,view1Fragment).commit();

        //텝에 이벤트 연결하기
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //텝이 선택될때 호출되는 메소드
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); //텝의 순서를 받아오기
                Log.d("tab",position+"");
                Fragment fragment = null;
                if (position==0){
                    fragment = view1Fragment;
                }else if (position==1){
                    fragment = view2Fragment;
                }else {
                    fragment = view3Fragment;
                }
                //텝을 선택할 때 지정된 프레그먼트 객체가 show되도록 연결
                getSupportFragmentManager().beginTransaction().replace(R.id.content_container,fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //BottomNavigationView이벤트 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.botton_item2){
                    getSupportFragmentManager().beginTransaction().
                                        replace(R.id.content_container,view2Fragment).commit();
                }
                return false;
            }
        });
    }
}
