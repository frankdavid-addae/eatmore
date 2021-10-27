package com.example.eatmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvCategories = findViewById(R.id.rvCategories);

        setCategories();
    }

    private void setCategories() {
        List<FoodCategory> foodCategoryList = new ArrayList<>();

        FoodCategory foodCategory = new FoodCategory("Chicken", R.drawable.ic_chicken);
        FoodCategory foodCategory2 = new FoodCategory("Burger", R.drawable.ic_burger);
        FoodCategory foodCategory3 = new FoodCategory("Pizza", R.drawable.ic_pizza);
        FoodCategory foodCategory4 = new FoodCategory("Chicken", R.drawable.ic_chicken);
        FoodCategory foodCategory5 = new FoodCategory("Chicken", R.drawable.ic_chicken);

        foodCategoryList.add(foodCategory);
        foodCategoryList.add(foodCategory2);
        foodCategoryList.add(foodCategory3);
        foodCategoryList.add(foodCategory4);
        foodCategoryList.add(foodCategory5);

        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(foodCategoryList, HomeActivity.this);

        rvCategories.setLayoutManager(new LinearLayoutManager(HomeActivity.this, RecyclerView.HORIZONTAL, false));
        rvCategories.setAdapter(foodCategoryAdapter);

        foodCategoryAdapter.notifyDataSetChanged();
    }
}