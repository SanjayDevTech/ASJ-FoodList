package com.sanjaydevtech.foodlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sanjaydevtech.foodlist.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var adapter: FoodAdapter

    private var isLinear: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val linearLayoutManager = LinearLayoutManager(this)
        val gridLayoutManager = StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)
        binding.recyclerView.adapter = adapter
        binding.actionButton.setOnClickListener {
            binding.recyclerView.layoutManager = if (isLinear) {
                isLinear = false
                binding.actionButton.setImageResource(R.drawable.ic_baseline_grid_on_24)
                gridLayoutManager
            } else {
                isLinear = true
                binding.actionButton.setImageResource(R.drawable.ic_baseline_view_list_24)
                linearLayoutManager
            }
        }
    }
}