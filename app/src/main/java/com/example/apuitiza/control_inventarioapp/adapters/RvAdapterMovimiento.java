package com.example.apuitiza.control_inventarioapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apuitiza.control_inventarioapp.R;
import com.example.apuitiza.control_inventarioapp.activities.DetalleMovimiento;
import com.example.apuitiza.control_inventarioapp.models.Movimiento;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ALEXANDRE on 25/12/2017.
 */

public class RvAdapterMovimiento extends RecyclerView.Adapter<RvAdapterMovimiento.MovimentoViewHolder> {

    private Context mContext;
    private List<Movimiento> mMovimientos;
    private SimpleDateFormat sdf;

    public static class MovimentoViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivImagen;
        public TextView tvDescripcion;
        public TextView tvFechaHora;
        public TextView tvCantidadMovimiento;
        public TextView tvUnidades;

        public MovimentoViewHolder(View v) {
            super(v);
            ivImagen = v.findViewById(R.id.civImagenProducto);
            tvDescripcion = v.findViewById(R.id.tvDescripcionProducto);
            tvFechaHora = v.findViewById(R.id.tvFechaHoraMovimiento);
            tvCantidadMovimiento = v.findViewById(R.id.tvCantidadMovimiento);
            tvUnidades = v.findViewById(R.id.tvUnidadesMovimiento);
        }
    }

    public void setAll(List<Movimiento> movimientos){
        this.mMovimientos = movimientos;
    }

    public RvAdapterMovimiento(Context context, List<Movimiento> movimientos) {
        this.mContext = context;
        this.mMovimientos = movimientos;
        this.sdf = new SimpleDateFormat("MMM dd\nyyy");
    }

    @Override
    public int getItemCount() {
        return mMovimientos.size();
    }

    @Override
    public RvAdapterMovimiento.MovimentoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movimiento, viewGroup, false);
        return new RvAdapterMovimiento.MovimentoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RvAdapterMovimiento.MovimentoViewHolder viewHolder, int position) {
        final Movimiento m = mMovimientos.get(position);

        Picasso.with(mContext).load(m.getProducto().getUrl()).into(viewHolder.ivImagen);
        viewHolder.tvDescripcion.setText(m.getProducto().getNombre());
        viewHolder.tvFechaHora.setText(sdf.format(new Date(m.getFechaHora())));
        viewHolder.tvCantidadMovimiento.setText(String.valueOf(m.getCantidad()));
        viewHolder.tvCantidadMovimiento.setText((m.getTipo() == 1 ? " + " : " - ") + String.valueOf(m.getCantidad()));
        viewHolder.tvCantidadMovimiento.setTextColor(m.getTipo() == 1 ? ContextCompat.getColor(mContext,R.color.green) :ContextCompat.getColor(mContext,R.color.red));
        viewHolder.tvUnidades.setTextColor(m.getTipo() == 1 ? ContextCompat.getColor(mContext,R.color.green) :ContextCompat.getColor(mContext,R.color.red));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,DetalleMovimiento.class));
            }
        });
    }
}
