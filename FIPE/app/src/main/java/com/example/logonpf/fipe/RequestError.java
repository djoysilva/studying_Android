package com.example.logonpf.fipe;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class RequestError implements Response.ErrorListener{

    @Override
    public void onErrorResponse(VolleyError error) {

        Log.e("FIPE", "Erro: " + error.getMessage());

    }
}
