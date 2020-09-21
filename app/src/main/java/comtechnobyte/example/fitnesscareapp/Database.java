package comtechnobyte.example.fitnesscareapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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



    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME , null, 1);
        SQLiteDatabase SQLiteDatabase = this.getWritableDatabase();



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
}
