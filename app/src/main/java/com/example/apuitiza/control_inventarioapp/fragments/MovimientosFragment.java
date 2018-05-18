package com.example.apuitiza.control_inventarioapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.apuitiza.control_inventarioapp.activities.NuevoMovimientoActivity;
import com.example.apuitiza.control_inventarioapp.adapters.RvAdapterMovimiento;
import com.example.apuitiza.control_inventarioapp.api.Api;
import com.example.apuitiza.control_inventarioapp.api.ApiService;
import com.example.apuitiza.control_inventarioapp.models.Movimiento;
import com.example.apuitiza.control_inventarioapp.R;
import com.example.apuitiza.control_inventarioapp.models.Producto;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovimientosFragment extends Fragment {

    private List<Movimiento> mMovimientos;
    private RecyclerView rvMovimientos;
    private RvAdapterMovimiento rvAdapterMovimiento;
    FloatingActionButton fbNuevoMov;

    private ApiService apiService = Api.getApi().create(ApiService.class);

    public MovimientosFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movimientos, container, false);

        fbNuevoMov = v.findViewById(R.id.fbNuevoMov);

        rvMovimientos = v.findViewById(R.id.rvMovimientos);
        rvAdapterMovimiento = new RvAdapterMovimiento(getActivity(),new ArrayList<Movimiento>());
        rvMovimientos.setAdapter(rvAdapterMovimiento);
        LinearLayoutManager ll = new LinearLayoutManager(getActivity());
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        rvMovimientos.setLayoutManager(ll);
        rvMovimientos.setHasFixedSize(true);
        mMovimientos = new ArrayList<>();
        mMovimientos.add(new Movimiento(1,1,new Producto(1,"COLGATE",10,"https://s2.dia.es/medias/hc3/h62/9311516164126.jpg",""),"10:30",10));
        rvAdapterMovimiento.setAll(mMovimientos);

        //loadMovimientos();
        fbNuevoMov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NuevoMovimientoActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }

    private void loadMovimientos() {
        Call<List<Movimiento>> callMovimientos = apiService.getMovimientos();
        callMovimientos.enqueue(new Callback<List<Movimiento>>() {
            @Override
            public void onResponse(Call<List<Movimiento>> call, Response<List<Movimiento>> response) {
                if(response.isSuccessful()) {
                    mMovimientos = response.body();
                    rvAdapterMovimiento.setAll(mMovimientos);
                }else{
                    Toast.makeText(getActivity(), "No se pudo cargar la información", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Movimiento>> call, Throwable t) {
                Toast.makeText(getActivity(), "No se pudo cargar la información", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
