package com.example.apuitiza.control_inventarioapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apuitiza.control_inventarioapp.models.Producto;
import com.example.apuitiza.control_inventarioapp.R;

import java.util.ArrayList;
import java.util.List;

public class ProductoRecyclerAdapter extends RecyclerView.Adapter<ProductoRecyclerAdapter.ProductoViewHolder>{

    private List<Producto> lstProducto;
    private Context mContext;

    public ProductoRecyclerAdapter(List<Producto> lstProducto, Context mContext) {
        this.lstProducto = lstProducto;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, final int position) {
        final Producto producto = lstProducto.get(position);
        holder.nameProducto.setText(producto.getNombre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,lstProducto.get(position).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstProducto.size();
    }

    public void setFilter (List<Producto> listaProductos){
        lstProducto =  new ArrayList<>();
        lstProducto.addAll(listaProductos);
        notifyDataSetChanged();
    }

    class ProductoViewHolder extends RecyclerView.ViewHolder{

        private TextView nameProducto;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            nameProducto =  itemView.findViewById(R.id.nameProduct);
        }
    }
}
