package com.example.qrcodegenerator;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText editText = findViewById(R.id.inputET);
        ImageView imageView = findViewById(R.id.imageView);
        MaterialButton generate = findViewById(R.id.generate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QRGEncoder qrgEncoder = new QRGEncoder(Objects.requireNonNull(editText.getText()).toString(), null, QRGContents.Type.TEXT, 200);
                try {
                    Bitmap bitmap = qrgEncoder.getBitmap(0);
                    imageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}