package com.example.eatmore;

public class FoodItem {
    private String foodName;
    private int foodPrice;
    private float foodRating;
    private int foodImage;

    public FoodItem(String foodName, int foodPrice, float foodRating, int foodImage) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodRating = foodRating;
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(float foodRating) {
        this.foodRating = foodRating;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }
}
