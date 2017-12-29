package pt.ipp.estgf.cmu_projeto.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipp.estgf.cmu_projeto.R;
import pt.ipp.estgf.database_library.Model.Categoria;

/**
 * Created by Bernardino on 29/12/2017.
 */

public class MyCategoriaAdapter extends ArrayAdapter<Categoria> {
    private Context context;
    private ArrayList<Categoria> categorias;

    public MyCategoriaAdapter(Context context, ArrayList<Categoria> categorias) {
        super(context, R.layout.row_categoria_button, categorias);
        this.context = context;
        this.categorias = categorias;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_categoria_button, null);
        }

        TextView btn = (TextView) v.findViewById(R.id.btnCategoria);
        btn.setText(categorias.get(position).getNome());

        return v;
    }
}
