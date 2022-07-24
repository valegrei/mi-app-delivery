package pe.edu.uni.valegrei.practica04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {
    public static final String PLATO_NOMBRE = "plato_nombre";
    public static final String PLATO_IMAGEN = "plato_imagen";
    public static final String PLATO_DESCRIP = "plato_nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        setTitle(R.string.title_orden);

    }
}