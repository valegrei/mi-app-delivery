package pe.edu.uni.valegrei.practica04;

import java.util.ArrayList;
import java.util.List;

public class Plato {
    private int resId;
    private String titulo;
    private String descripcion;

    public Plato() {
    }

    public Plato(Integer resId, String titulo, String descripcion) {
        this.resId = resId;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static List<Plato> obtenerDatos(){
        List<Plato> platos = new ArrayList<>();
        platos.add(new Plato(R.drawable.aji, "Aji de Pollo", "Un delicioso y amarillo aji de pollo."));
        platos.add(new Plato(R.drawable.arroz_con_pollo, "Arroz con Pollo", "Un verde arroz con pollo."));
        platos.add(new Plato(R.drawable.carapulcra, "Carapulcra", "Una deliciosa carapulcra."));
        platos.add(new Plato(R.drawable.ceviche, "Ceviche", "Un picante ceviche."));
        platos.add(new Plato(R.drawable.causa, "Causa Rellena", "Una deliciosa causa rellana de pollo."));
        platos.add(new Plato(R.drawable.lomo_saltado, "Lomo Saltado", "Un jugoso lomo saltado."));
        platos.add(new Plato(R.drawable.pollo_brasa, "Pollo a la Brasa", "Un crocante pollo a la brasa."));
        platos.add(new Plato(R.drawable.tacu_tacu, "Tacu Tacu", "Un delicioso tacu tacu a lo pobre."));
        return platos;
    }

}
