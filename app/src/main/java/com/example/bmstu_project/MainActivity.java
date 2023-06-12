package com.example.bmstu_project;


import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmstu_project.databinding.ActivityMainBinding;

import java.nio.charset.StandardCharsets;
import com.example.bmstu_project.databinding.ActivityMainBinding;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex;


public class MainActivity extends AppCompatActivity {

    public static native int initRng();

    public static native byte[] randomBytes(int no);





    public static native byte[] encrypt(byte[] key, byte[] data);

    public static native byte[] decrypt(byte[] key, byte[] data);
    public native String stringFromJNI();

    // Used to load the 'bmstu_project' library on application startup.
    static {
        System.loadLibrary("bmstu_project");
        System.loadLibrary("mbedcrypto");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activityResultLauncher  = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback() {
                    @Override
                    public void onActivityResult(Object result) {
                        if (((ActivityResult) result).getResultCode() == Activity.RESULT_OK) {
                            Intent data = ((ActivityResult) result).getData();
                            // обработка результата
                            String pin = data.getStringExtra("pin");
                            Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
;
    public static byte[] stringToHex(String s)
    {
        byte[] hex;
        try
        {
            hex = Hex.decodeHex(s.toCharArray());
        } catch (
                com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException e) {
            throw new RuntimeException(e);
        }
        return hex;
    }
    public void onButtonClick(android.view.View view) {
        Intent it = new Intent(this, PinpadActivity.class);
        //startActivity(it);
        activityResultLauncher.launch(it);
    }
    ActivityResultLauncher activityResultLauncher;

    public void onButtonClickThird(android.view.View view) {
        Intent it = new Intent(this, ThirdPart.class);
        startActivity(it);
    }
    public void onButtonClickFourth(android.view.View view) {
        Intent it = new Intent(this, FourthPart.class);
        startActivity(it);
    }



    /**
     * A native method that is implemented by the 'bmstu_project' native library,
     * which is packaged with this application.
     */

}

