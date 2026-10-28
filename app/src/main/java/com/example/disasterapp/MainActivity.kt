package com.example.disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapterDisaster by lazy {
        DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(this@MainActivity, "You clicked on ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(
                nameDisaster = "Tsunami",
                disasterType = "Natural",
                imageResId = R.drawable.tsunami
            ),
            Disaster(
                nameDisaster = "Volcanic Eruption",
                disasterType = "Natural",
                imageResId = R.drawable.volcanic_eruption
            ),
            Disaster(
                nameDisaster = "Earthquake",
                disasterType = "Natural",
                imageResId = R.drawable.earthquake
            ),
            Disaster(
                nameDisaster = "Flood",
                disasterType = "Natural",
                imageResId = R.drawable.flood
            ),
            Disaster(
                nameDisaster = "Fire",
                disasterType = "Natural",
                imageResId = R.drawable.fire
            ),
            Disaster(
                nameDisaster = "Nuclear Accident",
                disasterType = "Man-made",
                imageResId = R.drawable.nuclear
            ),
            Disaster(
                nameDisaster = "Terrorist Attack",
                disasterType = "Man-made",
                imageResId = R.drawable.terrorist
            ),
            Disaster(
                nameDisaster = "War",
                disasterType = "Man-made",
                imageResId = R.drawable.war
            )
        )
    }
}
