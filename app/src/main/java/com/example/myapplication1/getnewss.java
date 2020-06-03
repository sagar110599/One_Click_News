package com.example.myapplication1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class getnewss extends AppCompatActivity {
ListView lv;
public static List<news> newsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getnewss);

        newsList=(List<news>)getIntent().getSerializableExtra("fname");
        if(newsList.size()==0)
        {
            newsList.add(new news("no news found","please search properly","","","no results found"));
        }
        //newsList.add(new news(s,"sfdgfhfghfhffhfgfgfg"));
        //newsList.add(new news(s,"sfdgfhfghfhffhfgfgfg"));
        //newsList.add(new news(s,"sfdgfhfghfhffhfgfgfg"));
        lv=(ListView)findViewById(R.id.listview);
        mycustomadapter adpt=new mycustomadapter(this,R.layout.my_customlist,newsList);
        lv.setAdapter(adpt);

   }

}
