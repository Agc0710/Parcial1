package com.agc.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.ionbit.ionalert.IonAlert;
import model.Producto;

public class ExentosIva extends AppCompatActivity implements View.OnClickListener {

    private Button consultar;
    private Button costosos;
    private Button economicos;
    private Button promedio;

    private  Button atras;

    public static List<Producto> Lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exentos_iva);

        consultar = findViewById(R.id.btnconsultar);
        costosos = findViewById(R.id.btncostosos);
        economicos = findViewById(R.id.btnmenoscostoso);
        promedio =findViewById(R.id.btnpromedio);
        atras = findViewById(R.id.btnatras);

        consultar.setOnClickListener(this);
        costosos.setOnClickListener(this);
        economicos.setOnClickListener(this);
        promedio.setOnClickListener(this);
        atras. setOnClickListener(this);
        MainActivity Main = new MainActivity();
        Lista = Main.Lista;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnconsultar){


        }

        if(v.getId()== R.id.btnatras){
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);

        }
        if(v.getId()== R.id.btnpromedio){

            Promediosalario();
        }
        else if (v.getId() == R.id.btncostosos) {
            int vMayor = 0;
            String nombreProducto = "";

            for (int i = 0; i < this.Lista.size(); i++) {
                if (this.Lista.get(i).getValor() > vMayor) {

                    vMayor = this.Lista.get(i).getValor();
                    nombreProducto = "El producto mas costos es: " + this.Lista.get(i).getNombre() + " con un valor de " + this.Lista.get(i).getValor();
                }
            }
            new IonAlert(this).setTitleText(nombreProducto).show();

        }
        else if (v.getId() == R.id.btnmenoscostoso) {
            int valormenor = 999999;
            String nombreProducto = "";

            for (int i = 0; i < this.Lista.size(); i++) {
                if (this.Lista.get(i).getValor() < valormenor) {

                    valormenor = this.Lista.get(i).getValor();
                    nombreProducto = "El producto menos costos es: " + this.Lista.get(i).getNombre() + " con un valor de " + this.Lista.get(i).getValor();
                }
            }
            new IonAlert(this).setTitleText(nombreProducto).show();

        }
    }





    private void Promediosalario(){
        int sumaProductos= 0;
        double Productos = 0.0;
        for (int j= 0; j<this.Lista.size();j++){

            sumaProductos= (int) (sumaProductos + this.Lista.get(j).getValor());
        }
        Productos= (sumaProductos/this.Lista.size());
        new IonAlert(this).setTitleText("El promedio de los productos es:  " + Productos ).show();

    }

}