package com.melself.journey.ui.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.melself.journey.data.DBCountry;
import com.melself.journey.data.model.Country;
import com.melself.journey.data.repository.CountryRepository;
import com.melself.journey.ui.views.CountryFragment;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {

    private final CountryRepository countryRepository;
    private LiveData<List<Country>> getAllCountries;
    private LiveData<Country> getCountry;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        countryRepository = new CountryRepository(application);
        getAllCountries = countryRepository.getAllCountriesLive();
    }

    public void insert(Country country){
        countryRepository.insertCountry(country);
    }

    public void update(Country country){
        countryRepository.updateCountry(country);
    }

    public void delete(Country country){
        countryRepository.deleteCountry(country);
    }

    public LiveData<List<Country>> getAllCountriesFromView(){
        return getAllCountries;
    }

    public LiveData<Country> getCountryFromView(long id){
        return countryRepository.getCountryLive(id);
    }
}