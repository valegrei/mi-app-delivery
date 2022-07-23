package pe.edu.uni.valegrei.practica04;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_menu);
        initGrid();
    }

    private void initGrid() {
        List<Plato> platos = new ArrayList<>();

        GridAdapter adapter = new GridAdapter(this, platos);
        gridView.setAdapter(adapter);
    }
}