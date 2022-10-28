package com.melself.journey.ui.views;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melself.journey.MainActivity;
import com.melself.journey.R;
import com.melself.journey.databinding.FragmentSignUpBinding;
import com.melself.journey.databinding.FragmentSignUpContactBinding;
import com.melself.journey.ui.viewmodels.SignUpContactViewModel;

public class SignUpContactFragment extends Fragment {

    private SignUpContactViewModel mViewModel;
    FragmentSignUpContactBinding binding;

    public static SignUpContactFragment newInstance() {
        return new SignUpContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSignUpContactBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SignUpContactViewModel.class);
        // TODO: Use the ViewModel
    }
}