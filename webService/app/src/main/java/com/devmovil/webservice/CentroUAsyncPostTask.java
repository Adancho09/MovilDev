package com.devmovil.webservice;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CentroUAsyncPostTask extends AsyncTask<CentroUModel, Void,Void> {
    @Override
    protected Void doInBackground(CentroUModel... centrou) {

        StringBuffer respuesta = new StringBuffer();
        try {
            URL url = new URL("http://192.168.0.10:8080/centro");
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type","application/json");
            httpConnection.setDoInput(true);

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("nombre",)
            InputStream inputStream = new BufferedInputStream(httpConnection.());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            String linea = "";
            while((linea = bufferedReader.readLine()) != null){
                System.out.println(linea);
                respuesta.append(linea);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}