package org.bouzroura.taplapin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.bouzroura.taplapin.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<Button> buttons = new ArrayList<>();
    int positionLapin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //pour acceder a un bouton
        buttons.add(binding.b1);
        buttons.add(binding.b2);
        buttons.add(binding.b3);
        buttons.add(binding.b4);
        bougeLeLapin();
        binding.b1.setOnClickListener(view -> {
                    reagirClic(view);
        }
        );

    }

    private void reagirClic(View view) {
        Button boutonLapin = buttons.get(positionLapin);
        if(view == boutonLapin){
            Log.i("TAPELAPIN","Bravo !");
        }
        else {
            Log.i("TAPELAPIN","Bravo'nt !");
        }
        int a=0;
    }

    private void bougeLeLapin() {
        //remplir les boutons
        for (Button button : buttons){
            button.setText("taupe");
        }
        //trouver au hasard un bouton et mettre lapin
        Random random = new Random();
        positionLapin = random.nextInt(4);
        Button b = buttons.get(positionLapin);
        b.setText("Lapin");
    }
}