package com.melself.journey.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melself.journey.databinding.ListCountryBinding;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
    
        ListCountryBinding binding;

        public CountryViewHolder(ListCountryBinding item) {
            super(item.getRoot());
            binding = item;
        }
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(ListCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
