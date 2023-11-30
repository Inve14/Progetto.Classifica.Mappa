package com.example.appprogetto;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Classifica extends Fragment {

    private ClassificaViewModel viewModel;
    private List<String> help = new ArrayList<>();

    public Classifica() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.classifica, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        ApiInterface apiInterface = ClassificaRetrofitClient.getRetrofitIstance().create(ApiInterface.class);
        Call<List<User>> call = apiInterface.getUserInformation("l5p8XVRmz6ApeTVeeUwK");

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> risposta = response.body();
                    for (User user : risposta) {
                        help.add(user.getUid() + " " + user.getExperience());
                    }

                    // Dopo che la chiamata API è completata, crea il ViewModel e imposta la lista di aiuto
                    viewModel = new ViewModelProvider(requireActivity(), new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(ClassificaViewModel.class);
                    viewModel.setHelp(help);

                    ClassificaAdapter adapter = new ClassificaAdapter(requireContext(), viewModel, i -> {
                        Log.d("CapiamoMeglio", "(Fragment) Hai cliccato sull'elemento con posizione: " + i);
                    });

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("MainActivity", "onFailure: " + t.getMessage());
            }
        });

        return view;
    }
}
