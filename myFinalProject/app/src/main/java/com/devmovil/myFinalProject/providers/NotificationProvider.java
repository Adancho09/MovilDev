package com.devmovil.myFinalProject.providers;

import com.devmovil.myFinalProject.models.FCMBody;
import com.devmovil.myFinalProject.models.FCMResponse;
import com.devmovil.myFinalProject.retrofit.IFCMApi;
import com.devmovil.myFinalProject.retrofit.RetrofitClient;

import retrofit2.Call;

public class NotificationProvider {

    private String url = "https://fcm.googleapis.com";

    public NotificationProvider() {
    }

    public Call<FCMResponse> sendNotification(FCMBody body) {
        return RetrofitClient.getClientObject(url).create(IFCMApi.class).send(body);
    }
}
