package com.james.android_listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Country> countries=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        initCountries();
        CountryAdapter adapter=new CountryAdapter(
               MainActivity.this,R.layout.country_item,countries
        );
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //为listView注册一个项目点击监听器，点击item时会进行的操作
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Country country=countries.get(i);
                Toast.makeText(MainActivity.this,country.getCountryName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void  initCountries() {

        for (int i = 0; i < 2; i++) {
            Country germany = new Country(R.drawable.germany, "Germany");
            countries.add(germany);
            Country france = new Country(R.drawable.france, "France");
            countries.add(france);
            Country england = new Country(R.drawable.england, "England");
            countries.add(england);
            Country usa = new Country(R.drawable.usa, "USA");
            countries.add(usa);
            Country australia = new Country(R.drawable.australia, "Australia");
            countries.add(australia);
            Country argentina = new Country(R.drawable.argentina, "Argentina");
            countries.add(argentina);
            Country japan = new Country(R.drawable.japan, "Japan");
            countries.add(japan);
            Country italy = new Country(R.drawable.italy, "Italy");
            countries.add(italy);
            Country brazil = new Country(R.drawable.brazil, "Brazil");
            countries.add(brazil);

        }
    }

}
