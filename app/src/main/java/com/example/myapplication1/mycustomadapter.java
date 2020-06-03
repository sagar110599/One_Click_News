package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

public class mycustomadapter extends ArrayAdapter<news> {
    Context mctx;
    int resource;
    List<news> newsList;
    public mycustomadapter(Context mctx, int resource, List<news> newslist)
    {
        super(mctx,resource,newslist);
        this.mctx=mctx;
        this.resource=resource;
        this.newsList=newslist;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflate=LayoutInflater.from(mctx);
        View v=inflate.inflate(resource,null);
        TextView title_v=v.findViewById(R.id.title);
        TextView des_v=v.findViewById(R.id.des);
        Button btn=v.findViewById(R.id.get_full_text);
        ImageView im=v.findViewById(R.id.image);
        news n=newsList.get(position);
        Glide.with(mctx).load(n.getImg_url()).into(im);
        title_v.setText(n.getDate());
        des_v.setText(n.getDes());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    if(!newsList.get(position).getTitle().equals("no news found")){
                    Intent next=new Intent(mctx,full_new.class);
                    next.putExtra("myObj",(Serializable) newsList.get(position));
                    mctx.startActivity(next);}
                    else {
                        Intent next=new Intent(mctx,MainActivity.class);
                        mctx.startActivity(next);
                    }

            }
        });

        return v;
    }
}
