package com.melself.journey.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melself.journey.data.model.Country;
import com.melself.journey.databinding.ListCountryBinding;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> data = new ArrayList<>();

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ListCountryBinding binding;

        public CountryViewHolder(ListCountryBinding item) {
            super(item.getRoot());
            binding = item;
        }

        public void bindView(Country country){
            binding.nameCountryList.setText(country.getName());
            binding.descriptionCountryList.setText(country.getDescription());
            binding.priceCountryList.setText(country.getPrice() + " руб.");
        }
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListCountryBinding binding = ListCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CountryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {
        Country country = data.get(position);
        holder.bindView(country);

        holder.binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setCountry(List<Country> country){
        this.data = country;
        notifyDataSetChanged();
    }

    public void filterList(List<Country> filterList) {
        data = filterList;
        notifyDataSetChanged();
    }
}
