package com.example.fuzzy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity implements RecyclerViewInterface{
    ArrayList<UniModel> uniModels = new ArrayList<>();
    int[] Images = {R.drawable.msu, R.drawable.bauman, R.drawable.mirea, R.drawable.rudn, R.drawable.academ};
    int[] Gal1 = {R.drawable.msu_gal1, R.drawable.bauman_gal1, R.drawable.mirea_gal1, R.drawable.rudn_gal1, R.drawable.academ_gal1};
    int[] Gal2 = {R.drawable.msu_gal2, R.drawable.bauman_gal2, R.drawable.mirea_gal2, R.drawable.def, R.drawable.academ_gal2};
    int[] Gal3 = {R.drawable.msu_gal3, R.drawable.bauman_gal3, R.drawable.mirea_gal3, R.drawable.def, R.drawable.academ_gal3};

    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        searchView = findViewById(R.id.SearchView);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//                // sending
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                filterList(s);
//                return true;
//            }
//        });

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        setUniModels();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, uniModels, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void filterList(String s) {
        ArrayList<UniModel> fl = new ArrayList<>();
        for (UniModel uniModel:uniModels){
            if (uniModel.getName().toLowerCase().contains(s.toLowerCase())){
                fl.add(uniModel);
            }
        }
        if (fl.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setUniModels() {
        String[] uniNames = getResources().getStringArray(R.array.names);
        String[] programs = getResources().getStringArray(R.array.programs);
        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        for (int i = 0; i < uniNames.length; i++){
            uniModels.add(new UniModel(uniNames[i],
                    programs[i],
                    Images[i],
                    descriptions[i], Gal1[i], Gal2[i], Gal3[i]));
            System.out.println(
                    descriptions[i]);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("NAME", uniModels.get(position).getName());
        intent.putExtra("IMAGE", uniModels.get(position).getImage());
        intent.putExtra("PROGRAM", uniModels.get(position).getPr());
        intent.putExtra("DESCRIPTION", uniModels.get(position).getDescription());
        intent.putExtra("GAL1", uniModels.get(position).getGal1());
        intent.putExtra("GAL2", uniModels.get(position).getGal2());
        intent.putExtra("GAL3", uniModels.get(position).getGal3());

        startActivity(intent);
    }
}