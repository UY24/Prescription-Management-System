package com.example.phrapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class ImageInfoAdapter extends RecyclerView.Adapter<ImageInfoAdapter.ViewHolder> {
    private List<ImageInfo> listdata;

    // RecyclerView recyclerView;
    public ImageInfoAdapter(List<ImageInfo> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.image_info_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final ImageInfo myListData = listdata.get(position);
        // holder.description.setText(listdata.get(position).getDescription());
        holder.category.setText(listdata.get(position).getCategory());
        holder.reportType.setText(listdata.get(position).getReportType());
        holder.prescriptionImg.setImageBitmap(listdata.get(position).getImage());
        holder.docName.setText(listdata.get(position).getPatientName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity act = (AppCompatActivity) view.getContext();
                DocumentDetailsFragment detailViewFragment= new DocumentDetailsFragment();
                act.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,detailViewFragment).addToBackStack(null).commit();
                Bundle bundle = new Bundle();
                bundle.putSerializable("imageInfoObj", (Serializable) listdata.get(position));
                detailViewFragment.setArguments(bundle);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description;
        public TextView category;
        public TextView reportType;
        public TextView docName;
        public ImageView prescriptionImg;

        public ViewHolder(View itemView) {
            super(itemView);
            this.docName = (TextView) itemView.findViewById(R.id.txtViewDescription);
            this.category = (TextView) itemView.findViewById(R.id.txtViewCategory);
            this.reportType = (TextView) itemView.findViewById(R.id.txtViewReportType);
            this.prescriptionImg = (ImageView) itemView.findViewById(R.id.imageViewPrescription);
        }
    }
}