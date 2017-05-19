package com.example.logonpf.fipe;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestMarca implements Response.Listener<JSONArray>{

    private ArrayAdapter<Marca> adpMarca;

    public RequestMarca(ArrayAdapter<Marca> adpMarca) {
        this.adpMarca = adpMarca;
    }

    @Override
    public void onResponse(JSONArray response) {

        Log.i("FIPE", response.toString());

        for (int i = 0; i < response.length(); i++) {

            try {
                JSONObject obj = response.getJSONObject(i);
                Marca m = new Marca(obj.getInt("id"), obj.getString("fipe_name"));
                adpMarca.add(m);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
