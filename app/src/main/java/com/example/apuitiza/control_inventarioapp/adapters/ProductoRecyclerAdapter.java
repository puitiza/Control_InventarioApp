package com.example.apuitiza.control_inventarioapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apuitiza.control_inventarioapp.activities.NuevoMovimientoActivity;
import com.example.apuitiza.control_inventarioapp.activities.productoActivity;
import com.example.apuitiza.control_inventarioapp.models.Producto;
import com.example.apuitiza.control_inventarioapp.R;
import com.squareup.picasso.Picasso;

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
        Picasso.with(mContext).load(producto.getUrl()).into(holder.ivImagenProduct);
        holder.stockProduct.setText(String.valueOf(producto.getStock()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NuevoMovimientoActivity.class);
                intent.putExtra("producto",producto);
                ((productoActivity)mContext).setResult(Activity.RESULT_OK,intent);
                ((productoActivity) mContext).finish();
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
        private ImageView ivImagenProduct;
        private TextView stockProduct;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            nameProducto =  itemView.findViewById(R.id.nameProduct);
            ivImagenProduct =  itemView.findViewById(R.id.ivImagenProduct);
            stockProduct =  itemView.findViewById(R.id.stockProduct);
        }
    }
}
