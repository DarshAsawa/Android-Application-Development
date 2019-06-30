package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNew;
    TextView tvCall;
    ImageView imgReaction,imgCall,imgMap,imgWeb;
    final int Create=1;
    String name="",number="",web="",location="",mood="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew=findViewById(R.id.btnNew);
        imgReaction=findViewById(R.id.imgReaction);
        imgCall=findViewById(R.id.imgCall);
        imgMap=findViewById(R.id.imgMap);
        imgWeb=findViewById(R.id.imgWeb);

        imgReaction.setVisibility(View.GONE);
        imgCall.setVisibility(View.GONE);
        imgMap.setVisibility(View.GONE);
        imgWeb.setVisibility(View.GONE);


        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.intents.Details.class);
                startActivityForResult(intent,Create);

            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);

            }
        });
        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+web));
                startActivity(intent);
            }
        });

        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
                if(requestCode==Create){
                    if (resultCode==RESULT_OK){
                        imgReaction.setVisibility(View.VISIBLE);
                        imgCall.setVisibility(View.VISIBLE);
                        imgMap.setVisibility(View.VISIBLE);
                        imgWeb.setVisibility(View.VISIBLE);

                        name=data.getStringExtra("Name");
                        number=data.getStringExtra("Phone");
                        web=data.getStringExtra("Web");
                        location=data.getStringExtra("Map");
                        mood=data.getStringExtra("Mood");

                        if (mood=="Happy"){
                            imgReaction.setImageResource(R.drawable.good);
                        }
                        else if (mood=="OK"){
                            imgReaction.setImageResource(R.drawable.neutral);
                        }
                        else if(mood=="Sad")
                        {
                            imgReaction.setImageResource(R.drawable.not_good);
                        }

                    }
                    else{
                        Toast.makeText(this, "No Data Passed", Toast.LENGTH_SHORT).show();
                    }

                }
    }
}
