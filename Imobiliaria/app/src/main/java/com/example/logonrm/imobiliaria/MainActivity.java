package com.example.logonrm.imobiliaria;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String caminho;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        img = (ImageView) findViewById(R.id.imgFoto);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

        }
    }
    public void tirar(View v){
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        Log.i("Imobiliaria", "DIR = " + storageDir.getAbsolutePath());

        File image = null;
        try{
            image = File.createTempFile("foto", ".jpg", storageDir);
            Log.i("Imobiliaria", "File = " + image.getName());
            caminho = image.getAbsolutePath();

            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image));
            startActivityForResult(i, 0);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(caminho, bmOptions);
        img.setImageBitmap(bitmap);
    }

    public void  enviar(View v){
        try{
            byte[] b = IOUtils.toByteArray(new FileInputStream(caminho));
            String file = Base64.encodeToString(b, Base64.DEFAULT);

            JSONObject obj = new JSONObject();
            obj.put("propretario" , "Jose");
            obj.put("Imagem", file);

            Log.i("IMOBILIARIA", obj.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
