package com.jokenposimple.leviatamodder;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void escolhaPedra(View view){
        this.opcaoescolhida("pedra");
    }

    public void escolhaTesoura(View view){
        this.opcaoescolhida("tesoura");
    }

    public void escolhaPapel(View view){
        this.opcaoescolhida("papel");
    }

    public void opcaoescolhida(String escolhaUsuario){

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes [ numero ];

        ImageView imageresultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        switch (escolhaApp){
            case "pedra":
                imageresultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageresultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageresultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if((escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
           (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
           (escolhaApp == "papel" && escolhaUsuario == "pedra")){  //Condição em que o App ganha
            textoResultado.setText("Você perdeu :(");

        }else if((escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                 (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                 (escolhaUsuario == "papel" && escolhaApp == "pedra")){ //Condição em que o Usuário ganha
            textoResultado.setText("Você ganhou :)");

        }else{ // Caso dê Empate
            textoResultado.setText("Empatamos ;0");
        }

        System.out.println("item cliado: " + escolhaApp);
    }

}