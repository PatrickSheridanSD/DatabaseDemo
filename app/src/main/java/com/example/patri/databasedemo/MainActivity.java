package com.example.patri.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //START OF MY CODE

        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE, null);

            /*
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Paddy', 34)");

            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Niamh', 7)");

            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Naomi', 33)");

            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Patrick Jnr', 0)");
            */

            /*
            //2nd user table

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Paddy', 34)");

            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Niamh', 7)");

            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Naomi', 33)");

            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Patrick Jnr', 0)");

            */


            /*
            GENERAL QUERIES
             */

            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age < 18", null);

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name = 'Paddy' and age = 34" , null);

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'P%'", null);

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%'", null);

            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%' LIMIT 1", null);

            /*
            Delete TABLE INFO
             */

            //myDatabase.execSQL("DELETE FROM users WHERE name = 'Paddy'");
            //myDatabase.execSQL("DELETE FROM newUsers WHERE id = 1");

            /*
            UPDATE TABLESPACE
             */

            //myDatabase.execSQL("UPDATE users SET age = 2 WHERE name = 'Patrick jnr'");

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");


            c.moveToFirst();

            while (c != null){

                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("UserResults - id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
