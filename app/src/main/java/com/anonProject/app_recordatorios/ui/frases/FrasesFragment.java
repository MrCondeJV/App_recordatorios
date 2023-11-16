package com.anonProject.app_recordatorios.ui.frases;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.anonProject.app_recordatorios.AddFrases;
import com.anonProject.app_recordatorios.R;
import com.anonProject.app_recordatorios.databinding.FragmentFrasesBinding;

public class FrasesFragment extends Fragment {

    private FragmentFrasesBinding binding;
    ImageView addFrase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FrasesViewModel frasesViewModel =
                new ViewModelProvider(this).get(FrasesViewModel.class);

        binding = FragmentFrasesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        addFrase = root.findViewById(R.id.frase_add_activity);
        addFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Añadir Frase",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), AddFrases.class);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}