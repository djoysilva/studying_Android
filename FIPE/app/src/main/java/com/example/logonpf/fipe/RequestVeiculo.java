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


class RequestVeiculo implements Response.Listener<JSONArray> {

    private ArrayAdapter<Veiculo> adpVeiculo;

    public RequestVeiculo(ArrayAdapter<Veiculo> adpVeiculo) {
        this.adpVeiculo = adpVeiculo;
    }

     public void onResponse(JSONArray response) {

        Log.i("FIPE", response.toString());

        for (int i = 0; i < response.length(); i++) {

            try {
                JSONObject obj = response.getJSONObject(i);
                Veiculo v = new Veiculo(obj.getInt("id"), obj.getString("fipe_name"));
                adpVeiculo.add(v);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
