package com.sanjaydevtech.foodlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.sanjaydevtech.foodlist.Utils.launchUri
import com.sanjaydevtech.foodlist.databinding.ItemviewFoodBinding
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FoodAdapter @Inject constructor(
    private val foodList: List<Food>,
    @ActivityContext private val context: Context,
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(
        private val binding: ItemviewFoodBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.apply {
                nameText.text = food.name
                bannerImg.setImageResource(food.imageId)
                root.setOnClickListener {
                    launchUri(context, "https://en.wikipedia.org/wiki/${food.name}".toUri())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemviewFoodBinding.inflate(
            LayoutInflater.from(parent.context), parent, false,
        )
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}