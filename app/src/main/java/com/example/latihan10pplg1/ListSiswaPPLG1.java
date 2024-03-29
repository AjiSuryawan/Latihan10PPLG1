package com.example.latihan10pplg1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListSiswaPPLG1 extends AppCompatActivity implements AdapterListSiswa.ItemClickListener {

    RecyclerView rvListDataSiswa;
    List<ModelSiswa> listDataSiswa10PPLG1;
    AdapterListSiswa adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_siswa_pplg1);

        rvListDataSiswa = findViewById(R.id.rvListData);
        listDataSiswa10PPLG1 = new ArrayList<>();
        ModelSiswa siswa1 = new ModelSiswa();
        siswa1.setNama("Royyan");
        siswa1.setAlamat("Surabaya");
        siswa1.setNoAbsen("33");
        siswa1.setImage(R.drawable.logo_mu);
        listDataSiswa10PPLG1.add(siswa1);

        ModelSiswa siswa2 = new ModelSiswa();
        siswa2.setNama("Ocean");
        siswa2.setAlamat("Jogja");
        siswa2.setNoAbsen("29");
        siswa2.setImage(R.drawable.logo_mu);
        listDataSiswa10PPLG1.add(siswa2);

        ModelSiswa siswa3 = new ModelSiswa();
        siswa3.setNama("Rizal");
        siswa3.setAlamat("Sumbawa");
        siswa3.setNoAbsen("23");
        siswa3.setImage(R.drawable.logo_mu);
        listDataSiswa10PPLG1.add(siswa3);

        // call adapter data
        rvListDataSiswa.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListSiswa(this, listDataSiswa10PPLG1);
        adapter.setClickListener(this);
        rvListDataSiswa.setAdapter(adapter);



    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, listDataSiswa10PPLG1.get(position).getNama(), Toast.LENGTH_SHORT).show();
    }
}