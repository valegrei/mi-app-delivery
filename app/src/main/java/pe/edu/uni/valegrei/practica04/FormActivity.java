package pe.edu.uni.valegrei.practica04;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

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
    LinearLayout linearLayout;

    SharedPreferences sharedPreferences;
    ArrayAdapter<CharSequence> adapter;
    boolean isNuevo = false;

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
        linearLayout = findViewById(R.id.linear_layaout);

        //carga cantidad
        adapter = ArrayAdapter.createFromResource(this, R.array.cantidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCantidad.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            platoNombre = intent.getStringExtra(PLATO_NOMBRE);
            platoDescrip = intent.getStringExtra(PLATO_DESCRIP);
            platoImagen = intent.getIntExtra(PLATO_IMAGEN, 0);
            isNuevo = true;
        }

        cargarDatos();

        btnEnviar.setOnClickListener(v->enviar());
    }

    private void enviar(){
        String cantidad = (String) spCantidad.getSelectedItem();
        String destinatario = edtDestinatario.getText().toString().trim();
        String direccion = edtDireccion.getText().toString().trim();
        boolean isVisa = rbVisa.isChecked();
        boolean isEfectivo = rbEfectivo.isChecked();
        if(destinatario.isEmpty() || direccion.isEmpty() || (!isVisa && !isEfectivo) ){
            Snackbar.make(linearLayout, R.string.msg_snackbar, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.button_snackbar_text, v1 -> {

                    }).show();
            return;
        }
        String pago = (isVisa) ? getString(R.string.text_visa) : getString(R.string.text_efectivo);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_title);
        builder.setCancelable(false);
        builder.setMessage(getString(R.string.dialog_msg, platoNombre, cantidad, destinatario, direccion, pago));
        builder.setPositiveButton(R.string.yes, (dialog, which) -> {
            //Salir del aplicativo
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });
        builder.setNegativeButton(R.string.no, (dialog, which) -> {

        }).create().show();
    }

    private void cargarDatos() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        if (!isNuevo) {
            platoNombre = sharedPreferences.getString(PLATO_NOMBRE, "");
            platoDescrip = sharedPreferences.getString(PLATO_DESCRIP, "");
            platoImagen = sharedPreferences.getInt(PLATO_IMAGEN, 0);
        }

        int cantPos = sharedPreferences.getInt(CANT_POS_KEY, 0);
        String destinatario = sharedPreferences.getString(DESTINATARIO_KEY, null);
        String direccion = sharedPreferences.getString(DIRECCION_KEY, null);
        boolean isVisa = sharedPreferences.getBoolean(VISA_KEY, false);
        boolean isEfectivo = sharedPreferences.getBoolean(EFECTIVO_KEY, false);

        tvTitulo.setText(platoNombre);
        tvDescripcion.setText(platoDescrip);
        imgPlato.setImageResource(platoImagen);

        spCantidad.setSelection(cantPos);
        edtDestinatario.setText(destinatario);
        edtDireccion.setText(direccion);
        rbVisa.setChecked(isVisa);
        rbEfectivo.setChecked(isEfectivo);
    }

    @Override
    protected void onPause() {
        super.onPause();
        guardarDatos();
    }

    private static final String CANT_POS_KEY = "cant_pos";
    private static final String DESTINATARIO_KEY = "dest";
    private static final String DIRECCION_KEY = "direcc";
    private static final String VISA_KEY = "visa";
    private static final String EFECTIVO_KEY = "efectivo";

    private void guardarDatos() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        int cantPos = spCantidad.getSelectedItemPosition();
        String destinatario = edtDestinatario.getText().toString().trim();
        String direccion = edtDireccion.getText().toString().trim();
        boolean isVisa = rbVisa.isChecked();
        boolean isEfectivo = rbEfectivo.isChecked();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PLATO_NOMBRE, platoNombre);
        editor.putString(PLATO_DESCRIP, platoDescrip);
        editor.putInt(PLATO_IMAGEN, platoImagen);

        editor.putInt(CANT_POS_KEY, cantPos);
        editor.putString(DESTINATARIO_KEY, destinatario);
        editor.putString(DIRECCION_KEY, direccion);
        editor.putBoolean(VISA_KEY, isVisa);
        editor.putBoolean(EFECTIVO_KEY, isEfectivo);
        editor.apply();
    }

    private void limpiarDatos(){
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }
}