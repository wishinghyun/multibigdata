package multi.android.datamanagementpro.sqlite.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//데이터베이스가 업데이트되거나 DB를 처음 생성
public class EXAMDBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public EXAMDBHelper(Context context){
        //파일형태로 데이터가 저장된다 - 이 자체가 데이터베이스를 오픈하고 연결
        super(context,"product.db",null,DB_VERSION);
    }

    //앱이 설치되고 SQLiteOpenHelper가 최초로 호출될때 한 번만 실행
    //테이블이 생성되고 필요하면 초기화작업
    //앱을 최초로 다운받는 사람들을 위해서 만들어 놓은 메소드 - 항상 최신으로 유지
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("dbexam","데이터베이스가 생성되었습니다");

        //테이블 생성
        //autoincrement가 시퀀스랑 같음
        String sql = "create table if not exists product("
                + "_id integer primary key autoincrement,"
                + "name text not null,"
                + "price integer not null,"
                + "su integer not null,"
                + "totPrice integer not null)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("dbexam",
                "데이터베이스의 스키마가 변경되었습니다.");
        switch (oldVersion){
            case 1:
                //1버전에서 2버전으로 넘어갈때 처리해야 하는 일들을 구성
                Log.d("dbexam","2버전으로 변경");
            case 2:
                //2버전에서 3버전으로 넘어갈때
            case 3:
                //3버전에서 4버전으로 넘어갈때
        }
    }
}
