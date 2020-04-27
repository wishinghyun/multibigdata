package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Async_exam extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    ImageView imageView;
    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

    }
    public void ck_bt(View view){
        if (view.getId()==R.id.button){
            AsyncExam asyncExam = new AsyncExam();
            asyncExam.execute();
        }
    }
    class AsyncExam extends AsyncTask<Void,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            button.setClickable(false);
            button2.setClickable(true);
            progressBar.setMax(50);
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            Integer total = 0;
            for (int i = 1; i <= 50; i++){
                total = total+i;
                SystemClock.sleep(100);
                publishProgress(i);
            }
            return total;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText(Integer.toString(values[0]));
            progressBar.setProgress(values[0]);
            if (values[0]%2==0){
                imageView.setImageResource(R.drawable.d1);
            }else {
                imageView.setImageResource(R.drawable.d2);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            button.setClickable(true);
            button2.setClickable(false);
            textView.setText("Result : "+integer);
        }
    }
}
