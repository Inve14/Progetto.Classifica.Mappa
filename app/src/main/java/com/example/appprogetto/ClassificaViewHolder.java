package com.example.appprogetto;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassificaViewHolder extends RecyclerView.ViewHolder{

    private TextView contactNameTextView;
    private String previousText = "";

    private Classifica mainActivity;
    public ClassificaViewHolder(@NonNull View itemView, ClassificaRecyclerViewClickListener rvcl) {
        super(itemView);
        this.mainActivity = mainActivity;
        contactNameTextView = itemView.findViewById(R.id.contactTextView);
        itemView.setOnClickListener(v -> {
            rvcl.onItemClicked(getAdapterPosition());
        }
        );
    }

    public void bind(String contact) {
        previousText = contact;
        contactNameTextView.setText(contact);
    }
}
