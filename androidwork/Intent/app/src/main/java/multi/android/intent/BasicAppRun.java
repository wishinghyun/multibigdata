package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BasicAppRun extends AppCompatActivity {
    //승인받을 권한의 목록
    String[] permission_list = {
            Manifest.permission.CALL_PHONE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_app_run);

        //액티비티가 만들어질때 권한체크 메소드를 호출
        runPermission();
    }
    //구글맵실행
    public void runGoogleMap(View view){
        Uri uri = Uri.parse("geo:37.501579,127.039585");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //웹브라우저실행
    public void runWeb(View view){
        Uri uri = Uri.parse("https://www.daum.net");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //전화걸기화면만 실행
    public void runDial(View view){
        Uri uri = Uri.parse("tel:00000000");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    //실제 전화 걸기 위한 메소드
    public void runCallPhone(View v){
        Intent intent = null;
        int chk = PermissionChecker.checkSelfPermission(this,
                                                        Manifest.permission.CALL_PHONE);
        if (chk==PackageManager.PERMISSION_GRANTED){
            Log.d("tel","성공");
            intent = new Intent(Intent.ACTION_CALL,
                                Uri.parse("tel:5556"));
        }else {
            Log.d("tel","실패");
            return;
        }
        startActivity(intent);
    }
    //권한을 체크 - 승인처리
    public void runPermission(){
        //하위버전이면 실행되지 않도록 처리
        if (Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return;
        }
        //모든 권한을 셀프체크
        for (String permission:permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            if (chk== PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list,0); //requestCode는 아무거나
                break;
            }
        }
    }

}
