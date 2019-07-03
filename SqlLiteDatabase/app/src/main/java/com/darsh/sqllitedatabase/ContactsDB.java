package com.darsh.sqllitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDB
{
    public static final String KEY_ROWID="_id";
    public static final String KEY_NAME="person_name";
    public static final String KEY_NUMBER="_number";

    private final String Database_Name="Contactsdb";
    private final String Table_Name="Contactstable";
    private final int Database_version=1;

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public ContactsDB(Context context) {

        ourContext=context;
    }

    private class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context){
            super(context,Database_Name,null,Database_version);

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + Table_Name);
            onCreate(db);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            /*
            CREATE TABLE ContactsTable(_id integer primary key autoincrement,person_name text not null,_number text not null);

            */
            String sqlcode= "CREATE TABLE "+ Table_Name + " ("+ KEY_ROWID+" Integer primary key autoincrement, " +
                    KEY_NAME+" TEXT NOT NULL, " +
                    KEY_NUMBER +" TEXT NOT NULL);";
                db.execSQL(sqlcode);
        }


    }
    public ContactsDB open() throws  Exception
    {
        ourHelper=new DBHelper(ourContext);
        ourDatabase= ourHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        ourHelper.close();
    }

    public long createEntry(String name,String cell)
    {
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,name);
        cv.put(KEY_NUMBER,cell);
        return ourDatabase.insert(Table_Name,null,cv);

    }

    public String getData()
    {
        String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_NUMBER};
        Cursor c=ourDatabase.query(Table_Name,columns,null,null,null,null,null);

        String result="";

        int iRowid=c.getColumnIndex(KEY_ROWID);
        int iName=c.getColumnIndex(KEY_NAME);
        int iNumber=c.getColumnIndex(KEY_NUMBER);

        for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result = result +c.getString(iRowid) + " : " + c.getString(iName)+" : "+c.getString(iNumber)+"\n";

        }
        c.close();
        return result;
    }

    public long deleteEntry(String rowId)
    {
        return ourDatabase.delete(Table_Name,KEY_ROWID + "=?",new String[]{rowId});
    }

    public long updateEntry(String rowId,String name,String number)
    {
     ContentValues cv=new ContentValues();
     cv.put(KEY_NAME,name);
     cv.put(KEY_NUMBER,number);

     return ourDatabase.update(Table_Name,cv,KEY_ROWID+"=?",new String [] {rowId});

    }


}
