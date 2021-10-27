package com.example.eatmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvCategories, rvFoodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvCategories = findViewById(R.id.rvCategories);
        rvFoodItems = findViewById(R.id.rvFoodItems);

        setCategories();
        setFoodItems(0);
    }

    private void setCategories() {
        List<FoodCategory> foodCategoryList = new ArrayList<>();

        FoodCategory foodCategory = new FoodCategory("Chicken", R.drawable.ic_chicken);
        FoodCategory foodCategory2 = new FoodCategory("Burger", R.drawable.ic_burger);
        FoodCategory foodCategory3 = new FoodCategory("Pizza", R.drawable.ic_pizza);

        foodCategoryList.add(foodCategory3);
        foodCategoryList.add(foodCategory);
        foodCategoryList.add(foodCategory2);

        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(
            foodCategoryList, HomeActivity.this,
            new FoodCategoryAdapter.OnCategoryClickedListener() {
                @Override
                public void onCategoryClick(int position) {
                    setFoodItems(position);
                }
            }
        );

        rvCategories.setLayoutManager(new LinearLayoutManager(HomeActivity.this, RecyclerView.HORIZONTAL, false));
        rvCategories.setAdapter(foodCategoryAdapter);

        foodCategoryAdapter.notifyDataSetChanged();
    }

    private void setFoodItems(int categoryPosition) {
        List<FoodItem> foodItemList = new ArrayList<>();

        switch (categoryPosition) {
            case 0:
                FoodItem foodItem1 = new FoodItem("Pizza", 14, 3.5f, R.drawable.pizza_1);
                FoodItem foodItem2 = new FoodItem("Awesome Pizza", 14, 3.5f, R.drawable.pizza_2);
                FoodItem foodItem3 = new FoodItem("Crazy Pizza", 14, 3.5f, R.drawable.pizza_3);
                FoodItem foodItem4 = new FoodItem("Pizza 2 +", 14, 3.5f, R.drawable.pizza_4);

                foodItemList.add(foodItem1);
                foodItemList.add(foodItem2);
                foodItemList.add(foodItem3);
                foodItemList.add(foodItem4);

                break;
            case 1:
                FoodItem foodItem5 = new FoodItem("Chicken", 12, 4.5f, R.drawable.grill_chicken_1);
                FoodItem foodItem6 = new FoodItem("Grilled Chicken", 12, 4.5f, R.drawable.grill_chicken_2);
                FoodItem foodItem7 = new FoodItem("Chicken +", 13, 4.5f, R.drawable.grill_chicken_3);

                foodItemList.add(foodItem5);
                foodItemList.add(foodItem6);
                foodItemList.add(foodItem7);
                break;
            case 2:
                FoodItem foodItem8 = new FoodItem("Burger", 15, 4.0f, R.drawable.burger);
                FoodItem foodItem9 = new FoodItem("Amazing Burger", 16, 4.5f, R.drawable.burger_two);

                foodItemList.add(foodItem8);
                foodItemList.add(foodItem9);

        }



        FoodItemAdapter foodItemAdapter = new FoodItemAdapter(foodItemList);
        rvFoodItems.setLayoutManager(new LinearLayoutManager(HomeActivity.this, RecyclerView.HORIZONTAL, false));
        rvFoodItems.setAdapter(foodItemAdapter);
        foodItemAdapter.notifyDataSetChanged();
    }
}