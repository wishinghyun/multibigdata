package multi.android.datamanagementpro.exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class MemoExam extends AppCompatActivity {
    EditText view;
    boolean permission_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_exam);
        view = findViewById(R.id.memoTxt);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED) {
                permission_state = true;
                printToast("권한이 설정되었습니다");
        } else {
            permission_state = false;
            printToast("권한을 설정해야 합니다");
            //2. 권한이 없는 경우 권한을 설정하는 메시지를 띄운다 requestCode는 임의로 줘도 됨
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    10);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==10 && grantResults.length>0){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED &&
                grantResults[1]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                printToast("권한 설정 마무리 완료");
            }
        }else {
            printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다");
        }
    }

    public void memosave(View v){
        if (permission_state) {
            printToast("권한설정완료");
            //사용가능한 외부저장소가 있는지 state를 추출 - Environment.getExternalStorageState()
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)){ //사용 가능한 상태
                printToast("사용가능");
                File external = Environment.getExternalStorageDirectory();

                String dirPath = external.getAbsolutePath()+"/mynote";
                //외부경로 저장소 아래에 myApp을 만듬
                //  => 외부저장소/임의의 디렉토리를 생성 - 앱을 삭제해도 데이터는 남아있다


                //디렉토리가 없으면 생성
                File dir = new File(dirPath);
                if (!dir.exists()){ //dir.exists() 디렉토리가 있으면 true리턴
                    dir.mkdir();
                }
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/20200410_memo.txt");
                    fw.append(view.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (fw!=null) {
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }else {
                printToast("사용불가능");
            }
        } else {
            printToast("권한설정하세요");
        }
    }

    public void memoopen(View v){
        try {
            File external = Environment.getExternalStorageDirectory();
            File dir = new File(external.getAbsolutePath()+"/mynote");
            BufferedReader br = new BufferedReader(new FileReader(dir+"/20200410_memo.txt"));
            String line = "";
            StringBuffer sb = new StringBuffer();
            for (int i = 1;(line=br.readLine())!=null;i++){
                sb.append(line+"\n");
            }
            view.setText(sb);
            /*String line = br.readLine();
            while (line!=null){
                view.append(line+"\n");
                line = br.readLine();
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newmemo(View v){
        File external = Environment.getExternalStorageDirectory();
        File dir = new File(external.getAbsolutePath()+"/mynote");
        FileWriter fw = null;
        try {
            fw = new FileWriter(dir+"/20200410_memo.txt");
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw!=null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
