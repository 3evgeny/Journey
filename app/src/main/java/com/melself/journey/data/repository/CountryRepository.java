package com.melself.journey.data.repository;

import android.app.Application;
import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.melself.journey.data.AppDatabase;
import com.melself.journey.data.CountryDAO;
import com.melself.journey.data.DBCountry;
import com.melself.journey.data.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryRepository {

    private CountryDAO countryDAO;
    private LiveData<List<DBCountry>> getAllCountiesRepository;
    private LiveData<DBCountry> getCountryRepository;

    public CountryRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        countryDAO = appDatabase.getCountryDAO();
        getAllCountiesRepository = countryDAO.getAllCountries();
    }

    public void insertCountry(Country country){
        DBCountry dbCountry = DBCountry.convertToDBCountry(country);
        AppDatabase.databaseWriteExecutor.execute(() -> {
            countryDAO.insertCountry(dbCountry);
        });
    }

    public void updateCountry(Country country){
        DBCountry dbCountry = DBCountry.convertToDBCountry(country);
        AppDatabase.databaseWriteExecutor.execute(() -> {
            countryDAO.updateCountry(dbCountry);
        });
    }

    public void deleteCountry(Country country){
        DBCountry dbCountry = DBCountry.convertToDBCountry(country);
        AppDatabase.databaseWriteExecutor.execute(() -> {
            countryDAO.deleteCountry(dbCountry);
        });
    }

    public LiveData<List<Country>> getAllCountriesLive(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Transformations.map(countryDAO.getAllCountries(), dbCountries -> dbCountries.stream().map(dBCountry -> dBCountry.convertToCountry()).collect(Collectors.toList()));
        }
        return new MutableLiveData<List<Country>>(new ArrayList<>());
    }

    public LiveData<Country> getCountryLive(long id){
        //return Transformations.map(countryDAO.getCountry(id), dbCountries -> dbCountries.convertToCountry());
        return Transformations.map(countryDAO.getCountry(id), dbCountry -> dbCountry.convertToCountry());
    }
}























