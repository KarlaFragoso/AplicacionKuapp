package com.example.proyectokuap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    private int[] mImagenes = new int[]{
            R.drawable.guajolote,R.drawable.quesadilla,R.drawable.tlayoyos
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CarouselView carouselView = findViewById(R.id.carrusel);
        carouselView.setPageCount(mImagenes.length);

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImagenes[position]);
            }

        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this,mImagenes[position],Toast.LENGTH_SHORT).show();

            }
        });

        RelativeLayout Iniciar = findViewById(R.id.IniciarSesion);

        RelativeLayout restaurant = findViewById(R.id.Restaurant);


           //BOTON DE Restaurant
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resta = new Intent(MainActivity.this, ActivityRestaurant.class);
                MainActivity.this.startActivity(resta);
                //   onBackPressed();


            }
        });

        //BOTON DE Restaurant
        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regis = new Intent(MainActivity.this, ActivityInciarSesion.class);
                MainActivity.this.startActivity(regis);
                //   onBackPressed();


            }
        });


    }
}
