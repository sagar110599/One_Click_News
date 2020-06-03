package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;


public class data_from_api extends AsyncTask<Void,Void,Void>  {
       List<news> newsList=new ArrayList<>();

        Context main1;
        String line="";
        String source;
        String key;
        String date_from;
        String url="http://newsapi.org/V2/everything?";
        String api_key="&apiKey=ecd7d30f3c2c467f9af03b2de1d327bc";
        HashMap<String,String> lang=new HashMap<String, String>();

        public data_from_api(String key,String source,String date_from,Context main)
        {
            main1=main;
            lang.put("tamil","ta");
            lang.put("italian","it");
            lang.put("french","fr");
            lang.put("japanese","ja");
            lang.put("gujarati","gu");
            lang.put("hindi","hi");
            lang.put("german","de");
            lang.put("arabic","ar");
            lang.put("bengali","bn");
            lang.put("chinese","zh");
            lang.put("latin","la");
            lang.put("russian","ru");
            lang.put("dutch","nl");
            if(source.equals(""))
                this.source="sources?&";
            else
                this.source="sources="+source+"&";
            if(key.equals(""))
                this.key="q=top headlines"+"&";
            else
                this.key="q="+key+"&";
            if(!lang.containsKey(date_from.toLowerCase()))
                this.date_from="language=en";
            else
                this.date_from="language="+(String)lang.get(date_from.toLowerCase());
          // this.newsList.add(new news("as","sfdgfhfghfhffhfgfgfg"));
           // this.newsList.add(new news("asds","sfdgfhfghfhffhfgfgfg"));
            //this.newsList.add(new news("sadsa","sfdgfhfghfhffhfgfgfg"));


        }

        @Override
        protected  Void doInBackground(Void... voids) {
            try {
                URL u = new URL(url + key+source+date_from + api_key);
                HttpURLConnection http = (HttpURLConnection) u.openConnection();
                InputStream ip = http.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(ip));
                String l = "";
                while (l != null) {
                    l = br.readLine();
                    line = line + l;
                }

                JSONObject ja = new JSONObject(this.line);
                //for(int i=0;i<ja.length();i++){
                //JSONObject jo=(JSONObject)ja.get(i);
                //if(jo.get("status").equals("ok")){
                JSONArray article = new JSONArray(ja.get("articles").toString());
                //this.newsList.add(new news(ja.get("status").toString(), ja.get("articles").toString()));
                for (int j = 0; j < article.length(); j++) {
                    JSONObject jo1 = (JSONObject) article.get(j);
                    this.newsList.add(new news(jo1.get("title").toString(),jo1.get("description").toString() ,jo1.get("urlToImage").toString(),jo1.get("url").toString(),(jo1.get("publishedAt").toString()).split("T")[0]));
                }
                    //this.newsList.add(new news(ja.get("status").toString(), this.line));


                } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
            }

            @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent next=new Intent(main1,getnewss.class);
            next.putExtra("fname", (Serializable) newsList);
            main1.startActivity(next);

        }
    }


