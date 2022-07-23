package pe.edu.uni.valegrei.practica04;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    Context context;
    List<Plato> platos;

    public GridAdapter(Context context, List<Plato> platos) {
        this.context = context;
        this.platos = platos;
    }

    @Override
    public int getCount() {
        return platos.size();
    }

    @Override
    public Plato getItem(int position) {
        return platos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Plato item = getItem(position);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        ImageView imageView = view.findViewById(R.id.img_plato);
        TextView tvTitulo = view.findViewById(R.id.tv_titulo);
        TextView tvDescripcion = view.findViewById(R.id.tv_descripcion);
        imageView.setImageResource(item.getResId());
        tvTitulo.setText(item.getTitulo());
        tvDescripcion.setText(item.getDescripcion());
        return view;
    }
}
