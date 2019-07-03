package com.darsh.sqllitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    EditText etName,etPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=(EditText)findViewById(R.id.etName);
        etPhone=(EditText)findViewById(R.id.etPhone);

    }

    public void btnSubmitData(View view)
    {
        String name=etName.getText().toString().trim();
        String number=etPhone.getText().toString().trim();

        try{
            ContactsDB db=new ContactsDB(this);
            db.open();
            db.createEntry(name,number);
            db.close();
            Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etPhone.setText("");
        }
        catch(SQLException e){
            Toast.makeText(this, e.getMessage() , Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnShowData(View view)
    {
        startActivity(new Intent(MainActivity.this,Data.class));
    }

    public void btnEditData(View view)
    {
        try
        {
            ContactsDB db=new ContactsDB(this);
            db.open();
            db.updateEntry("1","John norris","123456789");
            db.close();

            Toast.makeText(this, "Succesfully Updated", Toast.LENGTH_SHORT).show();

        }
        catch (SQLException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnDeleteData(View view)
    {
        try
        {
            ContactsDB db =new ContactsDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
