package com.alberto.a12restaurantes;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alberto.a12restaurantes.model.Restaurante;

import java.util.ArrayList;
import java.util.List;


public class RestauranteFragment extends Fragment {

    // RECOMENDACION: Me declaro la variable fuera para acceder
    // a la variable fuera del onCreateView
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;

    // 3- Creamos una lista de Restaurantes
    List<Restaurante> restauranteList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;


    public RestauranteFragment() {
    }

    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Este metodo está asociado a un xml
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Aqui comprobamos que el elemento padre(xml) sea una instancia de RecyclerView
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                // Gestor del RecyclerView por defecto. Situa los elementos uno debajo del otro.
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // 4 - Lista de elementos (Restaurantes)
            restauranteList = new ArrayList<>();
            // 5 - Añadimos los restaurantes
            restauranteList.add(new Restaurante("Pizzería Don Topo","https://www.cadenadial.com/wp-content/uploads/2015/07/pizza1.jpg",4.0f,"Teruel, España"));
            restauranteList.add(new Restaurante("Restaurante Le Tour","https://moadrupalweb.blob.core.windows.net/moadrupalweb/original/5571_BurgerKing_HeroImage.jpg",3.0f,"Teruel, España"));
            restauranteList.add(new Restaurante("Bar La Esquinica","https://www.cadenadial.com/wp-content/uploads/2015/07/pizza1.jpg",5.0f,"Teruel, España"));
            restauranteList.add(new Restaurante("Bar Manolo","https://moadrupalweb.blob.core.windows.net/moadrupalweb/original/5571_BurgerKing_HeroImage.jpg",1.0f,"IES Chomon, Teruel, España"));

            // 2- Asociamos el adaptador al RecyclerView
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(), restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}










