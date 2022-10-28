package com.melself.journey.ui.views;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melself.journey.MainActivity;
import com.melself.journey.R;
import com.melself.journey.data.DBCountry;
import com.melself.journey.data.model.Country;
import com.melself.journey.databinding.FragmentCountryBinding;
import com.melself.journey.ui.Adapters.CountryAdapter;
import com.melself.journey.ui.viewmodels.CountryViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CountryFragment extends Fragment {

    private CountryViewModel mViewModel;
    FragmentCountryBinding binding;
    CountryAdapter countryAdapter;

    private List<Country> itemList = new ArrayList<>();
    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.recyclerCountry.setLayoutManager(new LinearLayoutManager(getContext()));

        countryAdapter = new CountryAdapter();
        binding.recyclerCountry.setAdapter(countryAdapter);

        binding.searchCountry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        List<Country> filterList = new ArrayList<>();
        for (Country item : itemList){
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(item);
            }
        }
        countryAdapter.filterList(filterList);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        //mViewModel.insert(new Country(0,"French", "fhsjf", "10000" ));

//        mViewModel.getCountryFromView(4).observe(getViewLifecycleOwner(), new Observer<Country>() {
//            @Override
//            public void onChanged(Country country) {
//                System.out.println(country.getName());
//                //mViewModel.delete(country);
//                country.setDescription("В любом уголке России есть масса интересных мест.");
//                country.setPrice("5000");
//                mViewModel.update(country);
//            }
//        });

        mViewModel.getAllCountriesFromView().observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countryAdapter.setCountry(countries);
                itemList.addAll(countries);
            }
        });
    }

}