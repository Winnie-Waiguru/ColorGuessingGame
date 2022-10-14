package com.example.colorguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colorguessinggame.databinding.ActivityLearnBinding

class LearnActivity : AppCompatActivity() {
    lateinit var binding: ActivityLearnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayColors()
    }

    fun displayColors(){
        var color1 = Color(R.drawable.blue_hexagon, "blue")
        var color2 = Color(R.drawable.green_cucumber, "green")
        var color3 = Color(R.drawable.orange_pumpkin, "orange")
        var color4 = Color(R.drawable.brown_bear, "brown")
        var color5 = Color(R.drawable.grey_cloud, "grey")
        var color6= Color(R.drawable.purple_hectagon, "purple")
        var color7 = Color(R.drawable.yellow_rectangle, "Yellow")
        var color8 = Color(R.drawable.red_circle, "red")
        var color9 = Color(R.drawable.pink_heart, "pink")

        var colors = listOf(color1, color2,color3, color4, color5, color6, color7, color8, color9)
        var colorAdapter = RecyclerAdapterColors(colors)
        binding.rvColors.layoutManager = LinearLayoutManager(this)
        binding.rvColors.adapter = colorAdapter
    }
}