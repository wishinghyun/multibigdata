package multi.android.material_design_pro2.drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import multi.android.material_design_pro2.R;

public class DrawerTest extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.main_drawer);
        //액션바에 버튼 설정 - 버튼을 선택하면 NavigationView가 display되고
        //                    다시 선택하면 화면에서 사라지도록 설정
        toggle = new ActionBarDrawerToggle(this,
                                            drawerLayout,
                                            R.string.open_str, //int라서 res에서 가져옴
                                            R.string.close_str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.main_drawer_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id ==R.id.item1){
                    Toast.makeText(DrawerTest.this,"내가 본 레시피",Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }
    //onOptionsItemSelected메소드 구현해 줘야 사용할 수 있다
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"선택",Toast.LENGTH_SHORT).show();
        if (toggle.onOptionsItemSelected(item)){
            Toast.makeText(this,"if",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
