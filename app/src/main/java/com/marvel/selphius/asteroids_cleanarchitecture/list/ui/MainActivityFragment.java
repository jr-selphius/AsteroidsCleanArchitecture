package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marvel.selphius.asteroids_cleanarchitecture.CustomApplication;
import com.marvel.selphius.asteroids_cleanarchitecture.R;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivityFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.main_progress_recycler_view)
    ProgressBar progress;

    @BindView(R.id.central_message)
    TextView centralMessage;

    @Inject
    TodayAsteroidsViewModelFactory mainViewModelFactory;

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
        ((CustomApplication) getActivity().getApplication()).createListComponent().inject(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainAsteroidsViewModel.class);

        setUpRecyclerView();

        mainViewModel.getAsteroids().observe(this, asteroids -> {
            if (asteroids != null) {
                asteroidsAdapter.replaceAsteroids(asteroids);
            }
        });

        mainViewModel.mustShowProgress().observe(this, isVisible -> progress.setVisibility(isVisible ? View.VISIBLE : View.GONE));

        mainViewModel.mustShowCenterMessage().observe(this, isVisible -> centralMessage.setVisibility(isVisible ? View.VISIBLE : View.GONE));

        mainViewModel.getCentralMessage().observe(this, integer -> {
            centralMessage.setText(integer);
            centralMessage.setVisibility(View.VISIBLE);
        });
    }

    private void setUpRecyclerView() {
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layout);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        asteroidsAdapter = new AsteroidsAdapter(new ArrayList<>());
        recyclerView.setAdapter(asteroidsAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        ((CustomApplication) getActivity().getApplication()).releaseListComponent();
    }
}
