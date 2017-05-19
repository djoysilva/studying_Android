package com.example.logonpf.fipe;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by logonrm on 18/05/2017.
 */

public class RequestModelo implements  Response.Listener<JSONArray>{
    private ArrayAdapter<Modelo>  adpModelo;

    public RequestModelo(ArrayAdapter<Modelo> adpModelo) { this.adpModelo = adpModelo; }


    @Override
    public void onResponse(JSONArray response) {
        Log.i("FIPE", response.toString());

        for(int i = 0; i < response.length(); i++)
            try {
                JSONObject obj = response.getJSONObject(i);
                Modelo m = new Modelo(obj.getInt("id"), obj.getString("fipe_nome"));
                adpModelo.add(m);
            } catch (JSONException e) {
                e.printStackTrace();

            }
    }
}
