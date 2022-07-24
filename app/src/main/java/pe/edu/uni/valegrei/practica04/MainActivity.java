package pe.edu.uni.valegrei.practica04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    List<Plato> platos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_menu);

        gridView = findViewById(R.id.grid_menu);
        initGrid();
        gridView.setOnItemClickListener((parent, view, position, id) -> goFormulario(platos.get(position)));
    }

    private void initGrid() {
        platos = new ArrayList<>();
        platos.add(new Plato(R.drawable.aji, "Aji de Pollo", "Un delicioso y amarillo aji de pollo."));
        platos.add(new Plato(R.drawable.arroz_con_pollo, "Arroz con Pollo", "Un verde arroz con pollo."));
        platos.add(new Plato(R.drawable.carapulcra, "Carapulcra", "Una deliciosa carapulcra."));
        platos.add(new Plato(R.drawable.ceviche, "Ceviche", "Un picante ceviche."));
        platos.add(new Plato(R.drawable.causa, "Causa Rellena", "Una deliciosa causa rellana de pollo."));
        platos.add(new Plato(R.drawable.lomo_saltado, "Lomo Saltado", "Un jugoso lomo saltado."));
        platos.add(new Plato(R.drawable.pollo_brasa, "Pollo a la Brasa", "Un crocante pollo a la brasa."));
        platos.add(new Plato(R.drawable.tacu_tacu, "Tacu Tacu", "Un delicioso tacu tacu a lo pobre."));
        GridAdapter adapter = new GridAdapter(this, platos);
        gridView.setAdapter(adapter);
    }

    private void goFormulario(Plato plato) {
        Intent intent = new Intent(this, FormActivity.class);
        intent.putExtra(FormActivity.PLATO_NOMBRE, plato.getTitulo());
        intent.putExtra(FormActivity.PLATO_IMAGEN, plato.getResId());
        intent.putExtra(FormActivity.PLATO_DESCRIP, plato.getDescripcion());
        startActivity(intent);
    }
}