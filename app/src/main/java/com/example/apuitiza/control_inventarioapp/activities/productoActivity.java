package com.example.apuitiza.control_inventarioapp.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apuitiza.control_inventarioapp.adapters.ProductoRecyclerAdapter;
import com.example.apuitiza.control_inventarioapp.models.Producto;
import com.example.apuitiza.control_inventarioapp.R;

import java.util.ArrayList;
import java.util.List;

public class productoActivity extends AppCompatActivity {

    SearchView searchView;

    private ProductoRecyclerAdapter recyclerAdapter;
    private List<Producto> lista_productos;
    private RecyclerView productoRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        getSupportActionBar().setTitle("Seleccione Producto");

        lista_productos =  new ArrayList<>();

        lista_productos.add(new Producto("colgate"));
        lista_productos.add(new Producto("cepillo"));
        lista_productos.add(new Producto("shampoo"));
        lista_productos.add(new Producto("caldo"));
        lista_productos.add(new Producto("zanahoria"));
        lista_productos.add(new Producto("bolsa"));
        lista_productos.add(new Producto("colgate"));
        lista_productos.add(new Producto("colgate"));
        lista_productos.add(new Producto("colgate"));
        lista_productos.add(new Producto("colgate"));

        productoRecycler = findViewById(R.id.recycleProduct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productoRecycler.setLayoutManager(linearLayoutManager);

        recyclerAdapter = new ProductoRecyclerAdapter(lista_productos,productoActivity.this);

        productoRecycler.setAdapter(recyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile,menu);
        final MenuItem myActionMenuItem =  menu.findItem(R.id.search);
        searchView = (SearchView)myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);

        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override            public boolean onQueryTextChange(String newText) {
                final  List<Producto> filtermodelist=filter(lista_productos,newText);
                recyclerAdapter.setFilter(filtermodelist);
                return true;
            }
        });
        return true;
    }

    private List<Producto> filter(List<Producto> pl,String query)
    {
        query=query.toLowerCase();
        final List<Producto> filteredModeList=new ArrayList<>();
        for (Producto producto:pl)
        {
            final String text=producto.getNombre().toLowerCase();
            if (text.startsWith(query))
            {
                filteredModeList.add(producto);
            }
        }
        return filteredModeList;
    }

    private void changeSearchViewTextColor(View view) {
        if (view != null) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(Color.WHITE);
            return;
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                changeSearchViewTextColor(viewGroup.getChildAt(i));
            }
        }
    }
}
}
