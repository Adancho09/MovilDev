package com.devmovil.webservice;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DivisaAsyncTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... divisasDeEntrada) {
        String divisaBase = divisasDeEntrada[0];
        StringBuffer respuesta = new StringBuffer();
        try {
            URL url = new URL("http://192.168.0.10:8080/ListarCentros");
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = new BufferedInputStream(httpConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            String linea = "";
            while((linea = bufferedReader.readLine()) != null){
                respuesta.append(linea);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta.toString();
    }
}