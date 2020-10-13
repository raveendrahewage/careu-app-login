package com.example.careu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class backgroundWorker1 extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    Toast toast;
    Intent intent;
    backgroundWorker1(Context ctx) {
        context=ctx;
    }
    @Override
    protected String doInBackground(String... strings) {
        String type=strings[0];
        String login_url="http://192.168.43.163:8080/careu/appphp/appRegistration.php";
        if(type.equals("register")) {
            try {
                String firstname=strings[1];
                String lastname=strings[2];
                String email=strings[3];
                String phonenumber=strings[4];
                String username=strings[5];
                String password=strings[6];
                String nic=strings[7];
                String address=strings[8];
                String relative1=strings[9];
                String relativephone1=strings[10];
                String relative2=strings[11];
                String relativephone2=strings[12];
                String relative3=strings[13];
                String relativephone3=strings[14];

                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String post_data=
                         URLEncoder.encode("firstName","UTF-8")+"="+URLEncoder.encode(firstname,"UTF-8")+"&"
                        +URLEncoder.encode("lastName","UTF-8")+"="+URLEncoder.encode(lastname,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("phoneNumber","UTF-8")+"="+URLEncoder.encode(phonenumber,"UTF-8")+"&"
                        +URLEncoder.encode("userName","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("NIC","UTF-8")+"="+URLEncoder.encode(nic,"UTF-8")+"&"
                        +URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"
                        +URLEncoder.encode("relative1","UTF-8")+"="+URLEncoder.encode(relative1,"UTF-8")+"&"
                        +URLEncoder.encode("relativephone1","UTF-8")+"="+URLEncoder.encode(relativephone1,"UTF-8")+"&"
                        +URLEncoder.encode("relative2","UTF-8")+"="+URLEncoder.encode(relative2,"UTF-8")+"&"
                        +URLEncoder.encode("relativephone2","UTF-8")+"="+URLEncoder.encode(relativephone2,"UTF-8")+"&"
                        +URLEncoder.encode("relative3","UTF-8")+"="+URLEncoder.encode(relative3,"UTF-8")+"&"
                        +URLEncoder.encode("relativephone3","UTF-8")+"="+URLEncoder.encode(relativephone3,"UTF-8")+"&";

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while ((line=bufferedReader.readLine())!=null) {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("Added")) {
            toast.makeText(context,"Request sent. Wait for confirmation.",Toast.LENGTH_LONG).show();
            intent=new Intent(context,MainActivity.class);
            context.startActivity(intent);
        } else {
            alertDialog.setTitle("Registration failed!");
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}