package multi.android.map_location_pro.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import multi.android.map_location_pro.R;

//위치정보를 가져오는 방법 - 두 가지 제공
//표준방법인 LocationManager를 통해 가져오기
//위치정보를 제공하는 객체의 종류와 현재 사용할 수 있는 위치정보 제공자를 확인
//오류상황 - avd에서 gps모듈을 제공하지 않는다 따라서 다른 Provider정보를
//          확인하고 사용할 수 있도록 작업
//          (GPS, NETWORK모듈을 함께 호출해서 먼저 받아지는 Provider를 이용해서
//          작업할 수 있도록 구현)
public class BasicLocationTest2 extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
    TextView result;
    boolean permission_state;
    List<String> provider_list; //전체 위치 제공자 목록
    List<String> enableProvider_list; //사용 가능한 위치 제공자 목록
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_location_test);
        result = findViewById(R.id.result); //결과를 출력할 뷰

        locationManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //위험권한 체크하기
        //FINE => GPS , COARSE => NETWORK
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED |
                ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            printToast("권한이 없습니다");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                 Manifest.permission.ACCESS_COARSE_LOCATION},
                    1000);
        } else {
            permission_state = true;
            printToast("권한을 설정했습니다");
            //권한설정이 완료되면 Provider목록을 가져와서 출력
            getProviderList();
            getLocation();
        }
    }
    //전체 위치제공자 객체목록과 사용가능한 객체목록을 출력
    public void getProviderList(){
        String msg = "모든 provider list..";
        //제공되는 모든 provider 목록을 가져오기
        provider_list = locationManager.getAllProviders();
        Log.d("msg",provider_list.size()+"");
        for (String provider:provider_list){
            msg = msg + "\n" + provider + "\n";
        }
        //result.setText(msg);

        //사용가능한 목록
        enableProvider_list = locationManager.getProviders(true);
        Log.d("msg",enableProvider_list.size()+"");
        msg = msg + "사용가능한 목록......\n";
        for (String provider:enableProvider_list){
            msg = msg + "\n" + provider + "\n";
        }
        result.append(msg+"\n");
    }
    //사용가능 provider를 이용해서 위치정보를 받아오기
    public void getLocation(){
        for (String provider:enableProvider_list){
            Location location = null;
            try{
                location = locationManager.getLastKnownLocation(provider);
                if (location!=null){
                    //위치정보 (위도,경도,고도..)
                    printInfo(provider,location);
                    //이벤트 연결
                    locationManager.requestLocationUpdates(provider,
                                                           3000,1,this);
                }
                Log.d("msg","========성공========");
            }catch (SecurityException e){
                Log.d("msg","========"+e.getMessage()+"========");
            }
        }
    }

    //위치정보를 출력하는 메소드
    public void printInfo(String provider,Location location){
        if (location!=null){
            result.append("============="+provider+"=============\n");
            result.append("Latitude"+location.getLatitude()+"\n");
            result.append("Longitude"+location.getLongitude()+"\n");

            Date date = new Date(location.getTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            result.append("시간:"+simpleDateFormat.format(date)+"\n");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000 && grantResults.length>0){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED &
                    grantResults[1]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                printToast("권한 설정 마무리 완료");
            }
        }else {
            printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다");
        }
    }

    /*public void startLocationService(){
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
    }*/

    public void printToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    //위치정보가 변경되면 호출되는 메소드
    @Override
    public void onLocationChanged(Location location) {
        Log.d("msg","위치정보가 변경되었습니다");
        String provider = location.getProvider(); //현재 정보를 제공하는 provider

        result.append("****************"+provider+"****************\n");
        result.append("Latitude"+location.getLatitude()+"\n");
        result.append("Longitude"+location.getLongitude()+"\n");

        Date date = new Date(location.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        result.append("시간:"+simpleDateFormat.format(date)+"\n");
    }
    //모듈이 변경될때
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
    //수신 가능상태
    @Override
    public void onProviderEnabled(String provider) {

    }
    //수신불가능
    @Override
    public void onProviderDisabled(String provider) {

    }
}
