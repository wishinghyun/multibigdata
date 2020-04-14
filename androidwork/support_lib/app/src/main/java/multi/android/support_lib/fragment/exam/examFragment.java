package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;

public class examFragment extends AppCompatActivity {
    view1Fragment view1Fragment = new view1Fragment();
    view2Fragment view2Fragment = new view2Fragment();
    view3Fragment view3Fragment = new view3Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear02);
    }
    public void btn_click(View v){
        setFragment(v.getTag().toString());
    }
    public void setFragment(String idx){
        Log.d("fragment",idx);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프레그먼트의 변화를 관리하는 객체
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (idx){
            case "0":
                transaction.replace(R.id.container,view1Fragment);
                break;
            case "1":
                transaction.replace(R.id.container,view2Fragment);
                break;
            case "2":
                transaction.replace(R.id.container,view3Fragment);
        }
        transaction.commit();
    }
}
