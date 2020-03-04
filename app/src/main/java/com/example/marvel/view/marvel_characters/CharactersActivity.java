package com.example.marvel.view.marvel_characters;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.marvel.view.BaseActivity;
import com.example.marvel.R;
import com.example.marvel.databinding.ActivityMarvelCharactersBinding;
import com.example.marvel.dependencies.AndroidApplication;
import com.example.marvel.dependencies.components.CharactersComponent;
import com.example.marvel.models.Item;

import java.util.ArrayList;

public class CharactersActivity extends BaseActivity {

    ActivityMarvelCharactersBinding activityMarvelCharactersBinding;

    CharactersComponent charactersComponent;

    CharactersActivityViewModel marvelCharactersActivityViewModel;
    MutableLiveData<ArrayList<Item>> items = new MutableLiveData<>();
    CharactersAdapter charactersAdapter;

    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeInjector();
        super.onCreate(savedInstanceState);

        activityMarvelCharactersBinding = DataBindingUtil.setContentView(this, R.layout.activity_marvel_characters);
        charactersComponent.inject(this);
        activityMarvelCharactersBinding.setActivity(this);

        //setup toolbar
        setSupportActionBar(activityMarvelCharactersBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        activityMarvelCharactersBinding.toolbar.setTitle("");
        activityMarvelCharactersBinding.toolbar.setSubtitle("");


        //setup viewModel
        marvelCharactersActivityViewModel = ViewModelProviders.of(this, getApplicationComponent().charactersViewModelFactory()).get(CharactersActivityViewModel.class);

        //call Api
        marvelCharactersActivityViewModel.getCharacters(items,"0");
        items.observe(this, new Observer<ArrayList<Item>>() {
            @Override
            public void onChanged(ArrayList<Item> items) {
                setAdapter(items);
                adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,marvelCharactersActivityViewModel.getCharactersNames(items) );

                activityMarvelCharactersBinding.listView.setAdapter(adapter);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case R.id.menu_action_search:

                SearchView mSearchView = (SearchView)item.getActionView();
                mSearchView.setQueryHint("Search");
                mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }
                    @Override
                    public boolean onQueryTextChange(String newText) {
                        activityMarvelCharactersBinding.listView.setVisibility(View.VISIBLE);
                        activityMarvelCharactersBinding.recycler.setVisibility(View.GONE);
                        adapter.getFilter().filter(newText);
                        return true;
                    }
                });
                return true;
        }
        return false;
    }

    /**
     *  Dagger 2
     */
    private void initializeInjector() {
        this.charactersComponent = ((AndroidApplication) getApplicationContext())
                .getApplicationComponent().charactersComponent().create();
    }

    /**
     * Destroy observaer when Activity is destroyed
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        marvelCharactersActivityViewModel.destroyDispose();
    }

    private void setAdapter(ArrayList<Item> items)
    {
        charactersAdapter = new CharactersAdapter(this, items);
        activityMarvelCharactersBinding.recycler.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
        activityMarvelCharactersBinding.recycler.setAdapter(charactersAdapter);
    }


}
