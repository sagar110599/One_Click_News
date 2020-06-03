package com.example.myapplication1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.List;

public class full_new extends AppCompatActivity {
WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_new);
        news n=(news)getIntent().getSerializableExtra("myObj");
        wb=(WebView)findViewById(R.id.web_view);
        wb.setWebViewClient(new WebViewClient());
wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl(n.getRes());


    }
}
