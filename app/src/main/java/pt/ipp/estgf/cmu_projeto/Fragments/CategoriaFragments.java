package pt.ipp.estgf.cmu_projeto.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import pt.ipp.estgf.cmu_projeto.Adapters.MyCategoriaAdapter;
import pt.ipp.estgf.cmu_projeto.Interfaces.OnCategoriaSelectedItem;
import pt.ipp.estgf.database_library.Model.Categoria;

public class CategoriaFragments extends ListFragment {
    private Context mContext;
    private MyCategoriaAdapter mAdapter;
    private ArrayList<Categoria> categorias;
    private OnCategoriaSelectedItem listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = getActivity();
        listener = (OnCategoriaSelectedItem) activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new MyCategoriaAdapter(mContext, categorias);
        categorias.clear();

        categorias.add(new Categoria(1, "Historia"));
        categorias.add(new Categoria(2, "Desporto"));
        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        listener.onCategoriaselected(categorias.get(position).getId_categoria());
    }

}
