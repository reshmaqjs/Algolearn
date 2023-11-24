package com.example.studentdata;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "coursedb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "mycourses";
    // below variable is for our id column.
    private static final String ID_COL = "id";
    // below variable id for our roll number.
    private static final String ROLL_COL = "rollno";


    // below variable is for our course name column
    private static final String NAME_COL = "name";


    // below variable for our branch column.
    private static final String BRANCH_COL = "branch";

    // below variable is for our course tracks column.
    private static final String SCORE_COL = "score";
    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROLL_COL+"INTEGER,"
                + NAME_COL + " TEXT,"
                + BRANCH_COL + " TEXT,"
                + SCORE_COL + "INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewData(int roll,String Name, String Branch,int Score) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ROLL_COL, roll);
        values.put(NAME_COL, Name);
        values.put(BRANCH_COL, Branch);
        values.put(SCORE_COL, Score);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

//    public ArrayList<CourseModal> readCourses() {
//        // on below line we are creating a
//        // database for reading our database.
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // on below line we are creating a cursor with query to read data from database.
//        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//
//        // on below line we are creating a new array list.
//        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();
//
//        // moving our cursor to first position.
//        if (cursorCourses.moveToFirst()) {
//            do {
//                // on below line we are adding the data from cursor to our array list.
//                courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
//                        cursorCourses.getString(4),
//                        cursorCourses.getString(2),
//                        cursorCourses.getString(3)));
//            } while (cursorCourses.moveToNext());
//            // moving our cursor to next.
//        }
//        // at last closing our cursor
//        // and returning our array list.
//        cursorCourses.close();
//        return courseModalArrayList;
//    }

    public String getData() {
        SQLiteDatabase db = this.getWritableDatabase();

        //db=this.getReadableDatabase();
        String[] columns=new String[] {ROLL_COL,NAME_COL,BRANCH_COL,SCORE_COL};
        Cursor cursor=db.query(TABLE_NAME,columns,null,null,null,null,null);

        int iId= cursor.getColumnIndex(ROLL_COL);
        int iName= cursor.getColumnIndex(NAME_COL);
        int iBranch= cursor.getColumnIndex(BRANCH_COL);
        int iScore= cursor.getColumnIndex(SCORE_COL);
        String result="";

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            result=result+
                    "Id: "+cursor.getString(iId)+ "\n"+
                    "Name: " +cursor.getString(iName)+"\n"+
                    "Branch: " +cursor.getString(iBranch)+ "\n"+
                    "Score: "+cursor.getString(iScore)+ "\n\n";
        }
        db.close();
        return result;
    }
    public void updateData(int roll,String Name, String Branch,int Score) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ROLL_COL, roll);
        values.put(NAME_COL, Name);
        values.put(BRANCH_COL, Branch);
        values.put(SCORE_COL, Score);

        // after adding all values we are passing
        // content values to our table.

            // on below line we are calling a update method to update our database and passing our values.
            // and we are comparing it with name of our course which is stored in original name variable.
            db.update(TABLE_NAME, values, ROLL_COL+"="+roll,null);
            db.close();
        }
public String getStud(int l ){
    SQLiteDatabase db = this.getWritableDatabase();
    String[] columns=new String[] {ROLL_COL,NAME_COL,BRANCH_COL,SCORE_COL};
    Cursor cursor=db.query(TABLE_NAME,columns,null,null,null,null,null);

    int iId= cursor.getColumnIndex(ROLL_COL);
    int iName= cursor.getColumnIndex(NAME_COL);
    int iBranch= cursor.getColumnIndex(BRANCH_COL);
    int iScore= cursor.getColumnIndex(SCORE_COL);
    String result="";

    for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
        if(l==Integer.parseInt(cursor.getString(iId))){
            result = "Id: " + cursor.getString(iId) + "\n" +
                    "Name: " + cursor.getString(iName) + "\n" +
                    "Branch: " + cursor.getString(iBranch) + "\n" +
                    "Score: " + cursor.getString(iScore) + "\n\n";
            break;
        }
    }
    db.close();
    return result;
}
public void deleteStudent(int l){
    SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_NAME,ROLL_COL+"="+l,null);
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}