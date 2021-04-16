package com.agc.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.ib.custom.toast.CustomToastView;
import com.omarshehe.forminputkotlin.FormInputText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import model.Producto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FormInputText Nombre;
    private FormInputText Codigo;
    private FormInputText Valor;
    private FormInputText Iva;
    private FormInputText Descripcion;
    private Button agregar;
    public static List<Producto> Lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre= findViewById(R.id.nombre);
        Codigo =findViewById(R.id.codigo);
        Valor= findViewById(R.id.Valor);
        Iva= findViewById(R.id.iva);
        Descripcion= findViewById(R.id.descripcion);
        agregar= findViewById(R.id.btnguardar);

        agregar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnguardar) {
            String nombre = Nombre.getValue();
            int codigo = Integer.parseInt(Codigo.getValue());
            int valor = Integer.parseInt(Valor.getValue());
            boolean iva = false;
            String descripcion = Descripcion.getValue();

            //variables de obtencion de datos de la funcion persona
            producto(nombre,codigo,valor,iva,descripcion);

        }
    }


    public void producto(String nombre,int codigo,int valor,boolean iva,String descripcion ) {
        if (nombre.equals("")) {
            CustomToastView.makeErrorToast(this, "Error al validar el nombre del producto", R.layout.custom_toast).show();
            return;
        }
        if(codigo==0){
            CustomToastView.makeInfoToast(this,"Error al validar el codigo ",R.layout.custom_toast).show();
            return;
        }
        if(valor==0){
            CustomToastView.makeInfoToast(this,"Error al validar el valor",R.layout.custom_toast).show();
            return;
        }
        if (iva) {
            CustomToastView.makeErrorToast(this, "Error al validar el iva", R.layout.custom_toast).show();
            return;
        }
        if (descripcion.equals("")) {
            CustomToastView.makeErrorToast(this, "Error al validar la descripcion", R.layout.custom_toast).show();
            return;
        }
        //instanciar clase
        Producto producto= new Producto(nombre,codigo,valor,iva,descripcion);

        this.Lista.add(producto);

        Nombre.setValue("");
        Codigo.setValue("");
        Valor.setValue("");
        Iva.setValue("");
        Descripcion.setValue("");



        Intent myIntent = new Intent(this, ExentosIva.class);
        startActivity(myIntent);


    }
}