package comtechnobyte.example.fitnesscareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper  {

    public static final String DATABASE_NAME = "Bmi.db";
    public static final String TABLE_NAME = "Bmi_table";
    public static final String COL_1= "ID";
    public static final String COL_2 = "GENDER";
    public static final String COL_3= "DATE";
    public static final String COL_4 = "WEIGHT";
    public static final String COL_5 = "HIGHT";
    public static final String COL_6 = "ANSWER";
    private String[] selectionArgs;


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME , null, 1);





    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+ TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,GENDER TEXT,DATE INT,WEIGHT FLOAT,HIGHT FLOAT,ANSWER CHAR )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean inserData(String Gender,String date, String weight ,String hight,String answer){
        SQLiteDatabase SQLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(COL_2,Gender);
        contentValues.put(COL_3,date);
        contentValues.put(COL_4,weight);
        contentValues.put(COL_5,hight);
        contentValues.put(COL_6,answer);
        long result=SQLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return  false;
        else
            return true;


    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase myDb = this.getReadableDatabase();

        Cursor cursor = null;
        if (myDb != null){


            cursor =myDb.rawQuery(query,null);
        }
        return cursor;

    }


}
