package com.example.latihan10pplg1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListSiswa extends RecyclerView.Adapter<AdapterListSiswa.ViewHolder>{

    private List<ModelSiswa> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    AdapterListSiswa(Context context, List<ModelSiswa> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public AdapterListSiswa.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListSiswa.ViewHolder holder, int position) {
        ModelSiswa dataSiswa = mData.get(position);
        holder.tvName.setText(dataSiswa.getNama());
        holder.tvAlamat.setText(dataSiswa.getAlamat());
        holder.profilePicture.setImageResource(dataSiswa.getImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvAlamat;
        ImageView profilePicture;


        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            profilePicture = itemView.findViewById(R.id.ivProfilePicture);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ModelSiswa getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}


