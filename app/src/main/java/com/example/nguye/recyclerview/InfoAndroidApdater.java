package com.example.nguye.recyclerview;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAndroidApdater extends RecyclerView.Adapter<InfoAndroidApdater.ViewHolder>{
    ArrayList<AndroidVersion> androidVersions;

    public InfoAndroidApdater(ArrayList<AndroidVersion> androidVersions) {
        this.androidVersions = androidVersions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_name.setText(androidVersions.get(position).getName());
        holder.txt_version.setText(androidVersions.get(position).getVersion());
        holder.txt_api.setText(androidVersions.get(position).getApi());
    }

    @Override
    public int getItemCount() {
        return androidVersions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name;
        TextView txt_version;
        TextView txt_api;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_name     = (TextView) itemView.findViewById(R.id.text_name);
            txt_version  = (TextView) itemView.findViewById(R.id.text_version);
            txt_api      = (TextView) itemView.findViewById(R.id.text_api);
        }
    }
}
