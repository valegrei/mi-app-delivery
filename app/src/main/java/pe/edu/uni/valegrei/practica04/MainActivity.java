package pe.edu.uni.valegrei.practica04;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    List<Plato> platos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Si hay datos pasa a formulario
        if (hayDatosGuardados()) {
            goFormulario();
        }

        //Titulo
        setTitle(R.string.title_menu);

        gridView = findViewById(R.id.grid_menu);
        initGrid();

        gridView.setOnItemClickListener((parent, view, position, id) -> goFormulario(platos.get(position)));
    }

    private void initGrid() {
        platos = Plato.obtenerDatos();
        GridAdapter adapter = new GridAdapter(platos);
        gridView.setAdapter(adapter);
    }

    private void goFormulario() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
        finish();
    }

    private void goFormulario(Plato plato) {
        Intent intent = new Intent(this, FormActivity.class);
        intent.putExtra(FormActivity.PLATO_NOMBRE, plato.getTitulo());
        intent.putExtra(FormActivity.PLATO_IMAGEN, plato.getResId());
        intent.putExtra(FormActivity.PLATO_DESCRIP, plato.getDescripcion());
        startActivity(intent);
        finish();
    }

    private boolean hayDatosGuardados() {
        SharedPreferences sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        int imageGuardada = sharedPreferences.getInt(FormActivity.PLATO_IMAGEN, 0);
        return imageGuardada != 0;
    }
}