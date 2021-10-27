package com.example.eatmore;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.CategoryHolder> {

    List<FoodCategory> foodCategoryList;
    Context context;
    int selectedCategoryPosition = 0;
    OnCategoryClickedListener onCategoryClickedListener;

    public FoodCategoryAdapter(List<FoodCategory> foodCategoryList, Context context,
       OnCategoryClickedListener onCategoryClickedListener) {
        this.foodCategoryList = foodCategoryList;
        this.context = context;
        this.onCategoryClickedListener = onCategoryClickedListener;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.category_view_holder, parent, false);

        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.tvFoodCategoryName.setText(foodCategoryList.get(position).getName());
        holder.ivFoodCategoryImage.setImageResource(foodCategoryList.get(position).getImage());

        if (position == selectedCategoryPosition) {
            holder.tvFoodCategoryName.setTextColor(context.getColor(R.color.red));
            holder.ivFoodCategoryImage.setColorFilter(ContextCompat.getColor(context, R.color.red), PorterDuff.Mode.SRC_ATOP);
            holder.mcvCategory.setOutlineAmbientShadowColor(context.getColor(R.color.red));
            holder.mcvCategory.setOutlineSpotShadowColor(context.getColor(R.color.red));
            holder.mcvCategory.setStrokeWidth(2);
        } else {
            holder.tvFoodCategoryName.setTextColor(context.getColor(R.color.grey_one));
            holder.ivFoodCategoryImage.setColorFilter(ContextCompat.getColor(context, R.color.grey_one), PorterDuff.Mode.SRC_ATOP);
            holder.mcvCategory.setOutlineAmbientShadowColor(context.getColor(R.color.grey_one));
            holder.mcvCategory.setOutlineSpotShadowColor(context.getColor(R.color.grey_one));
            holder.mcvCategory.setStrokeWidth(0);
        }
    }

    @Override
    public int getItemCount() {
        return foodCategoryList.size();
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        TextView tvFoodCategoryName;
        ImageView ivFoodCategoryImage;
        MaterialCardView mcvCategory;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            tvFoodCategoryName = itemView.findViewById(R.id.tvFoodCategoryName);
            ivFoodCategoryImage = itemView.findViewById(R.id.ivFoodCategoryImage);
            mcvCategory = itemView.findViewById(R.id.mcvCategory);

            mcvCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedCategoryPosition = getAdapterPosition();
                    if (onCategoryClickedListener != null) {
                        onCategoryClickedListener.onCategoryClick(getAdapterPosition());
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface OnCategoryClickedListener {
        void onCategoryClick(int position);
    }
}
