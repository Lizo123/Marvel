package com.example.marvel.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class CheckConnectivity {

    static boolean isConnected(Context context)
    {
        Boolean isConnected= false ;// Initial Value
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork= connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected())
            isConnected = true;
        return isConnected;
    }
}
