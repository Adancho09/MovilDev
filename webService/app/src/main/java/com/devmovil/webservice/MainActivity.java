package com.devmovil.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText siglas;
    EditText nombre;
    EditText latitud;
    EditText longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siglas  =  (EditText) findViewById(R.id.siglas);
        nombre  =  (EditText) findViewById(R.id.nombre);
        latitud  =  (EditText) findViewById(R.id.latitud);
        longitud  =  (EditText) findViewById(R.id.longitud);

        CentrosUAsyncTask acceso= new CentrosUAsyncTask();
            String respuesta= null;
            try {
                respuesta = acceso.execute().get();

                    JSONArray jsonArray = new JSONArray(respuesta);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String siglasText = jsonObject.getString("siglas");
                    String nombreTxt = jsonObject.getString("siglas");
                    double latitudResponse = jsonObject.getDouble("latitud");
                    double longitudResponse = jsonObject.getDouble("longitud");
                    siglas.setText(siglasText);
                    nombre.setText(nombreTxt);
                    longitud.setText(String.valueOf(longitudResponse));
                    latitud.setText(String.valueOf(latitudResponse) );
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


    }


}