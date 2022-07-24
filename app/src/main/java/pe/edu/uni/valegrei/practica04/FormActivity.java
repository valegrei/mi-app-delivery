package pe.edu.uni.valegrei.practica04;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {
    public static final String PLATO_NOMBRE = "plato_nombre";
    public static final String PLATO_IMAGEN = "plato_imagen";
    public static final String PLATO_DESCRIP = "plato_nombre";

    String platoNombre, platoDescrip;
    Integer platoImagen;

    TextView tvTitulo, tvDescripcion;
    ImageView imgPlato;
    Spinner spCantidad;
    EditText edtDestinatario, edtDireccion;
    RadioButton rbVisa, rbEfectivo;
    Button btnEnviar;

    SharedPreferences sharedPreferences;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        setTitle(R.string.title_orden);

        tvTitulo = findViewById(R.id.tv_titulo);
        tvDescripcion = findViewById(R.id.tv_descripcion);
        imgPlato = findViewById(R.id.img_plato);
        spCantidad = findViewById(R.id.sp_cantidad);
        edtDestinatario = findViewById(R.id.edt_destinatario);
        edtDireccion = findViewById(R.id.edt_direccion);
        rbVisa = findViewById(R.id.rb_visa);
        rbEfectivo = findViewById(R.id.rb_efectivo);
        btnEnviar = findViewById(R.id.btn_enviar);

        //carga cantidad
        adapter = ArrayAdapter.createFromResource(this, R.array.cantidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCantidad.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            platoNombre = intent.getStringExtra(PLATO_NOMBRE);
            platoDescrip = intent.getStringExtra(PLATO_DESCRIP);
            platoImagen = intent.getIntExtra(PLATO_IMAGEN, 0);
        }
    }

    private void cargarDatos(){

    }

    private static final String CANT_POS_KEY = "cant_pos";
    private static final String DESTINATARIO_KEY = "dest";
    private static final String DIRECCION_KEY = "direcc";
    private static final String VISA_KEY = "visa";
    private static final String EFECTIVO_KEY = "efectivo";

    private void guardarDatos(){
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        int cantPos = spCantidad.getSelectedItemPosition();
        String destinatario = edtDestinatario.getText().toString();
        String direccion = edtDireccion.getText().toString();
        boolean isVisa = rbVisa.isChecked();
        boolean isEfectivo = rbEfectivo.isChecked();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key name", name);
        editor.putString("key message", message);
        editor.putInt("key counter", counter);
        editor.putBoolean("key remember", isChecked);
        editor.apply();
    }
}