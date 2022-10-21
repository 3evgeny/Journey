package com.melself.journey.ui.views;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melself.journey.R;
import com.melself.journey.databinding.FragmentTicketBinding;
import com.melself.journey.ui.viewmodels.TicketViewModel;

public class TicketFragment extends Fragment {

    private TicketViewModel mViewModel;
    FragmentTicketBinding binding;

    public static TicketFragment newInstance() {
        return new TicketFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTicketBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TicketViewModel.class);
        // TODO: Use the ViewModel
    }

}