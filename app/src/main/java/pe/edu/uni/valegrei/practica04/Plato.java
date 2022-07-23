package pe.edu.uni.valegrei.practica04;

public class Plato {
    private Integer resId;
    private String titulo;
    private String descripcion;

    public Plato() {
    }

    public Plato(Integer resId, String titulo, String descripcion) {
        this.resId = resId;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Integer getResId() {
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


}
