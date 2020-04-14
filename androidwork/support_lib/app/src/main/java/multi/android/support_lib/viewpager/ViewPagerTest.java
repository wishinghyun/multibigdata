package multi.android.support_lib.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.zip.Inflater;

import multi.android.support_lib.R;
/*
 화면 전환을 위해 ViewPager를 사용하는 경우(ListView와 동일)
 1. ViewPager에 담을 데이터 - View, Fragment
 2. Adapter 커스터마이징
 3. ViewPager에 Adapter연결하기
 */
public class ViewPagerTest extends AppCompatActivity {
    //1. ViewPager에 표시할 뷰를 저장할 List
    ArrayList<View> viewList = new ArrayList<View>();
    ViewPager mainPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
        mainPager = findViewById(R.id.mainPager);

        //ViewPager에 담을 View객체를 생성
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.view1,null);
        View view2 = inflater.inflate(R.layout.view2,null);
        View view3 = inflater.inflate(R.layout.view3,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        //3. ViewPager에 어뎁터 연결
        MainPagerAdapter adapter = new MainPagerAdapter();
        mainPager.setAdapter(adapter);
    }
    //2. Adapter커스트마이징
    class MainPagerAdapter extends PagerAdapter{
        //ViewPager를 통해 보여줄 뷰의 갯수 리턴
        @Override
        public int getCount() {
            return viewList.size();
        }
        //ViewPager에 보여줄 뷰를 등록
        //getView와 같은 역할
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            mainPager.addView(viewList.get(position));
            return viewList.get(position);
        }
        //매개변수로 전달된 뷰들끼리 비교
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            mainPager.removeView((View)object);
        }
    }
}
