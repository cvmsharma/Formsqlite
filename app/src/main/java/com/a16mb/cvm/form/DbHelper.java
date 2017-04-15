package com.a16mb.cvm.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**z
 * Created by Shivam Sharma on 4/15/2017.
 */
public class DbHelper extends SQLiteOpenHelper{

    public static final String DB_NAME="mydb";
    public static final String TABLE_NAME="mytable";
    public static final int DB_VERSION=1;
    public static final String COLUMN_NAME1="Name";
    public static final String COLUMN_NAME2="EMail";
    public static final String COLUMN_NAME3="Phone";
    public static final String COLUMN_NAME4="Password";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String NEW_TABLE="CEREATE TABLE"+TABLE_NAME+"("
                +COLUMN_NAME1+"TEXT,"
                + COLUMN_NAME2+"TEXT,"
                + COLUMN_NAME3+"TEXT,"
                + COLUMN_NAME4+"TEXT)";
        sqLiteDatabase.execSQL(NEW_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS,"+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void insertRecord(String Signup_Name,String Signup_Email,String Signup_Phone,String Signup_Password)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_NAME1, Signup_Name);
        cv.put(COLUMN_NAME2, Signup_Email);
        cv.put(COLUMN_NAME3, Signup_Phone);
        cv.put(COLUMN_NAME4, Signup_Password);
        sqLiteDatabase.insert(TABLE_NAME,null,cv);
        close();
    }
}
