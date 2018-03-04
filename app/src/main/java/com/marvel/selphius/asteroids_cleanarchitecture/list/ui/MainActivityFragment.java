package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.selphius.asteroids_cleanarchitecture.R;
import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivityFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    private MainAsteroidsViewModel mainViewModel;

    private AsteroidsAdapter asteroidsAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = ViewModelProviders.of(this).get(MainAsteroidsViewModel.class);

        setUpRecyclerView();

        mainViewModel.loadAsteroids();

        mainViewModel.getAsteroids().observe(this, new Observer<List<Asteroide>>() {
            @Override
            public void onChanged(@Nullable List<Asteroide> asteroids) {
                asteroidsAdapter.replaceAsteroids(asteroids);
                asteroidsAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setUpRecyclerView() {
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layout);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        asteroidsAdapter = new AsteroidsAdapter(Collections.EMPTY_LIST);
        recyclerView.setAdapter(asteroidsAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
