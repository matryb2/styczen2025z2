package com.example.styczen2025z2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean guzikWlaczony = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button zatwierdz = findViewById(R.id.button);
        Button wlacz = findViewById(R.id.button3);
        EditText inputNumer = findViewById(R.id.editTextText2);
        TextView numerPralki = findViewById(R.id.textView6);
        TextView statusOdkurzacza = findViewById(R.id.textView8);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        wlacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!guzikWlaczony) {
                    guzikWlaczony = true;
                    statusOdkurzacza.setText("Odkurzacz włączony");
                } else {
                    statusOdkurzacza.setText("Odkurzacz wyłączony");
                    guzikWlaczony = false;
                }
            }
        });

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputNumer.getText().toString();
                if (!text.isEmpty()) {
                    try {
                        int numer = Integer.parseInt(text);

                        if (numer >= 1 && numer <= 12) {
                            numerPralki.setText("Numer prania: " + numer);
                        } else {
                            Toast.makeText(MainActivity.this, "Podaj liczbę od 1 do 12", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Wpisz poprawną liczbę", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Proszę wpisać pole", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}