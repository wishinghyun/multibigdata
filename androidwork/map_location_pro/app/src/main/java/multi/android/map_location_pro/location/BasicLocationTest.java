package multi.android.map_location_pro.location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import multi.android.map_location_pro.R;
//위치정보를 가져오는 방법 - 두 가지 제공
//표준방법인 LocationManager를 통해 가져오기
//위치정보를 제공하는 객체의 종류와 현재 사용할 수 있는 위치정보 제공자를 확인
//오류상황 - avd에서 gps모듈을 제공하지 않는다
public class BasicLocationTest extends AppCompatActivity {
    LocationManager locationManager;
    TextView result;
    boolean permission_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_location_test);
        //result = findViewById(R.id.)
        //위험권한 체크하기
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            permission_state = true;
            printToast("권한이 설정되었습니다");
        } else {
            permission_state = false;
            printToast("권한을 설정해야 합니다");
            //2. 권한이 없는 경우 권한을 설정하는 메시지를 띄운다 requestCode는 임의로 줘도 됨
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1000);
        }
        startLocationService();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000 && grantResults.length>0){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                printToast("권한 설정 마무리 완료");
            }
        }else {
            printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다");
        }
    }

    public void startLocationService(){
        locationManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //위치정보를 제공하는 제공자로부터
        //위치정보를 담고 있는 Location객체를 가져오기
        try {
            Location location =
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location!=null){//위도 경도
                double Latitude = location.getLatitude();
                double Longitude = location.getLongitude();
                Log.d("msg",Latitude+","+Longitude);
            }else {
                Log.d("msg","location객체 실패");
            }
        }catch (SecurityException e){
            Log.d("msg",e.getMessage());
        }
    }

    public void printToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
