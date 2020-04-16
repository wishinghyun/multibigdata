package multi.android.material_design_pro.exam;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;


public class examFragment extends AppCompatActivity {
    TabLayout tabLayout;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    String[] tabdatalist = {"추천여행지","축제","나의여행지"};
    ViewPager fragment_viewPager;
    view1Fragment view1Fragment = new view1Fragment();
    ListTestFragment view2Fragment = new ListTestFragment();
    view3Fragment view3Fragment = new view3Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);
        tabLayout = findViewById(R.id.tabs_exam);
        fragmentArrayList.add(view1Fragment);
        fragmentArrayList.add(view2Fragment);
        fragmentArrayList.add(view3Fragment);

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),fragmentArrayList.size());
        fragment_viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(fragment_viewPager);
        fragment_viewPager.addOnPageChangeListener(new PageListener());
    }
    class FragAdapter extends FragmentStatePagerAdapter {

        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabdatalist[position];
        }
    }

    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을때
            Toast.makeText(examFragment.this,"페이지가 전환",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
