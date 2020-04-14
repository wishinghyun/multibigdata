package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;
import java.util.List;

import multi.android.support_lib.R;

public class examFragment extends AppCompatActivity {
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    ViewPager fragment_viewPager;
    view1Fragment view1Fragment = new view1Fragment();
    //view2Fragment view2Fragment = new view2Fragment();
    ListTestFragment view2Fragment = new ListTestFragment();
    view3Fragment view3Fragment = new view3Fragment();
    view4Fragment view4Fragment = new view4Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);
        fragmentArrayList.add(view1Fragment);
        fragmentArrayList.add(view2Fragment);
        fragmentArrayList.add(view3Fragment);
        fragmentArrayList.add(view4Fragment);

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),fragmentArrayList.size());
        fragment_viewPager.setAdapter(adapter);
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
    }
    public void btn_click(View view){
        fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
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
