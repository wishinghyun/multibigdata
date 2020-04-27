package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskTest extends AppCompatActivity {
    TextView view1;
    TextView view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_test);
        view1 = findViewById(R.id.txtView1);
        view2 = findViewById(R.id.txtView2);

        AsyncTaskExam asyncTaskExam = new AsyncTaskExam();
        //매개변수를 정의하면 매개변수가 doInBackground를 호출할때 전달
        asyncTaskExam.execute(10,20);//이 숫자가 doInBackground의 변수(Integer... integers)로 전달됨
                                     //타입은 AsyncTaskExam extends AsyncTask<첫번째 타입,__,__>

    }
    public void btn_click(View view){
        long now_time = System.currentTimeMillis();
		view1.setText(now_time+"");
    }

    //AsyncTask클래스를 상속하여 작업할 클래스를 정의
    //       extends AsyncTask<Integer,Long,String>
    //                        <doInBackground(___),onProgressUpdate(___),onPostExecute(___)>
    class AsyncTaskExam extends AsyncTask<Integer,Long,String>{//만약 부분적으로 없으면 Void
        @Override
        protected void onPreExecute() {//초기작업
            super.onPreExecute();
            Log.d("myasync","onPreExecute호출..작업시작");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int num1 = integers[0];
            int num2 = integers[1];
            for (int i=1;i<=10;i++){
                SystemClock.sleep(1000);
                Log.d("myasync","i="+i+", num1="+num1+", num2="+num2);
                long now_time = System.currentTimeMillis();
                //발생되는 값으로 UI를 변경하고 싶은 경우
                publishProgress(now_time);//onProgressUpdate의 변수(Long으로 전달됨)
            }
            return "모든 처리 작업이 완료";
        }

        @Override
        protected void onProgressUpdate(Long... values) {//작업중 화면 변경
            super.onProgressUpdate(values);
            //doInBackground에서 발생하는 값을 이용해서 화면을 변경하고 싶은 경우
            view2.setText("Async테스트:"+values[0]);
        }

        @Override
        protected void onCancelled() {//중간에 작업 취소될때
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String s) {//작업 끝나고 반납할 데이터 처리
            super.onPostExecute(s);
            view1.setText("반환값 : "+s);
        }
    }
   
}
