package com.learntospell.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class RingkasanHasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_ringkasan_hasil);


        Intent intent = getIntent();
        String level = intent.getStringExtra("LEVEL");
        int benar = intent.getIntExtra("JUMLAH_BENAR", 0);
        int salah = intent.getIntExtra("JUMLAH_SALAH", 0);
        int jumlah_soal = intent.getIntExtra("JUMLAH_SOAL", 0);
        ArrayList<String> soalsalah = intent.getStringArrayListExtra("DAFTAR_SALAH");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                soalsalah
        );

        TextView summaryText = findViewById(R.id.ringkasan);
        summaryText.setText("LEVEL" + level +
                "\n Benar: " + benar +
                "\n Salah: " + salah +
                "\n Nilai: " + benar * 100 / jumlah_soal);

        ListView listsalah = findViewById(R.id.listsalah);
        listsalah.setAdapter(adapter);

        Button btnMainLagi = findViewById(R.id.btnmainlagi);
        btnMainLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}