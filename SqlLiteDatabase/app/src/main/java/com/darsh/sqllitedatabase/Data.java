package com.darsh.sqllitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class Data extends AppCompatActivity {
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tvDisplay=findViewById(R.id.tvDisplay);

        try {
            ContactsDB db=new ContactsDB(this);
            db.open();
            tvDisplay.setText(db.getData());
            db.close();
        }
        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
