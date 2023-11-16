package com.anonProject.app_recordatorios.ui.actividades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.anonProject.app_recordatorios.databinding.FragmentActividadesBinding;

public class ActividadesFragment extends Fragment {

    private FragmentActividadesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ActividadesViewModel actividadesViewModel =
                new ViewModelProvider(this).get(ActividadesViewModel.class);

        binding = FragmentActividadesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       // final TextView textView = binding.textActividades;
        //actividadesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}