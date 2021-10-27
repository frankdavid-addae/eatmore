package com.example.eatmore;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodHolder> {

    List<FoodItem> foodItemList;
    int selectedFoodPosition = 0;

    public FoodItemAdapter(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.food_view_holder, parent, false);
        return new FoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        holder.ivFoodImage.setImageResource(foodItemList.get(position).getFoodImage());
        holder.tvFoodName.setText(foodItemList.get(position).getFoodName());
        holder.tvFoodPrice.setText(String.format("$%d", foodItemList.get(position).getFoodPrice()));
        holder.rbFoodRating.setRating(foodItemList.get(position).getFoodRating());

        if (selectedFoodPosition == position) {
            holder.tvFoodName.setTextColor(Color.WHITE);
            holder.tvFoodPrice.setTextColor(Color.WHITE);
            holder.cvFoodBg.animate().scaleX(1.1f);
            holder.cvFoodBg.animate().scaleY(1.1f);
            holder.llFood.setBackgroundResource(R.drawable.launcher_image);
        } else {
            holder.tvFoodName.setTextColor(Color.BLACK);
            holder.tvFoodPrice.setTextColor(Color.BLACK);
            holder.cvFoodBg.animate().scaleX(1.0f);
            holder.cvFoodBg.animate().scaleY(1.0f);
            holder.llFood.setBackgroundResource(R.color.white);
        }
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    class FoodHolder extends RecyclerView.ViewHolder {
        ImageView ivFoodImage;
        TextView tvFoodName, tvFoodPrice;
        RatingBar rbFoodRating;
        CardView cvFoodBg;
        LinearLayout llFood;

        public FoodHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodImage = itemView.findViewById(R.id.ivFoodImage);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);
            tvFoodPrice = itemView.findViewById(R.id.tvFoodPrice);
            rbFoodRating = itemView.findViewById(R.id.rbFoodRating);
            cvFoodBg = itemView.findViewById(R.id.cvFoodBg);
            llFood = itemView.findViewById(R.id.llFood);

            cvFoodBg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedFoodPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}
