package com.example.list;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] fruitNames = {"Banana", "Grape", "Guava", "Mango", "Orange", "Watermelon"};
    int[] fruitImageIds = {
            R.drawable.images,
            R.drawable.grapes,
            R.drawable.guava,
            R.drawable.mango,
            R.drawable.orange,
            R.drawable.watermelons
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the ListView
        ListView listView = findViewById(R.id.listview);

        // Create list data
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < fruitNames.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("fruitName", fruitNames[i]);
            map.put("fruitImage", fruitImageIds[i]);
            list.add(map);
        }

        // Map data to views
        String[] from = {"fruitName", "fruitImage"};
        int[] to = {R.id.textView, R.id.imageView};

        // Adapter
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.list_row_items,
                from,
                to
        );

        // Bind images correctly
        adapter.setViewBinder((view, data, textRepresentation) -> {
            if (view instanceof android.widget.ImageView && data instanceof Integer) {
                ((android.widget.ImageView) view).setImageResource((Integer) data);
                return true;
            }
            return false;
        });

        // Set adapter
        listView.setAdapter(adapter);
    }
}
