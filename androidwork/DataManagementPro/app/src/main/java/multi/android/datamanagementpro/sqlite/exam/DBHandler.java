package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DBHandler{
    private EXAMDBHelper helper;
    private SQLiteDatabase db;
    private DBHandler(Context context) {
        this.helper = new EXAMDBHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public static DBHandler open(Context context) throws SQLException {
        DBHandler handler = new DBHandler(context);
        // 위의 객체 생성후 db 와 TABLE 이 생성
        return handler;
    }
    public void close() {
        helper.close();
    }

    public void insert(String name, String price, String su){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("price",price);
        contentValues.put("su",su);
        contentValues.put("totPrice",Integer.toString(Integer.parseInt(price)*Integer.parseInt(su)));

        db.insert("product",null,contentValues);
    }

    public Cursor selectAll(){
        Cursor cursor = db.query("product",null,null,
                null,null,null,null);
        return cursor;
    }

    public Cursor search(String str){
        String string = "%"+str+"%";
        Cursor cursor = db.query("product",null,"name like ?",
                new String[]{string},null,null,null);
        return cursor;
    }

}
