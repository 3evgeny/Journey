package com.melself.journey.ui.views;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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

import java.util.List;

public class CountryFragment extends Fragment {

    private CountryViewModel mViewModel;
    FragmentCountryBinding binding;
    CountryAdapter countryAdapter;

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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        //mViewModel.insert(new Country(0,"Россия", "fhsjf", "10000" ));


//        mViewModel.getCountryFromView().observe(getViewLifecycleOwner(), new Observer<Country>() {
//            @Override
//            public void onChanged(Country country) {
//                System.out.println(country.getName());
//                mViewModel.delete(country);
//            }
//        });

        mViewModel.getAllCountriesFromView().observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countryAdapter.setCountry(countries);
                System.out.println(countries);
            }
        });
    }

}