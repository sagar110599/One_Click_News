package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView input1,input2,input3;
Button getn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "hello world",Toast.LENGTH_SHORT).show();

        input1=(TextView)findViewById(R.id.keyword);
        input2=(TextView)findViewById(R.id.from_date);
        input3=(TextView)findViewById(R.id.sources);
        getn=(Button)findViewById(R.id.getnext);
        getn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data_key=(input1.getText()).toString();
                String data_date=(input2.getText()).toString();
                String data_sources=(input3.getText()).toString();
             data_from_api d=new data_from_api(data_key,data_sources,data_date,MainActivity.this);
             d.execute();
               /* Intent next=new Intent(MainActivity.this,getnewss.class);
                next.putExtra("fname",data1);
                next.putExtra("lname",data2);
                next.putExtra("mname",data3);
                startActivity(next);
*/


            }
        });


    }
}
