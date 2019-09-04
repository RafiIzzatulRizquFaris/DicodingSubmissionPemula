package tech.toughput.dicodingsubmissionpemula

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val beautifulIndo = findViewById<ImageView>(R.id.beautiful_indo)
        Glide.with(this).load(R.drawable.beautiful_indo).error(R.drawable.ic_launcher_background).into(beautifulIndo)

        val traditionalFood = findViewById<ImageButton>(R.id.traditional_food)
        traditionalFood.setOnClickListener {
            val moveFood = Intent(this@MainActivity, FoodActivity::class.java)
            startActivity(moveFood)
        }
        Glide.with(this).load(R.drawable.traditional_food).error(R.drawable.ic_launcher_background).into(traditionalFood)

        val traditionalHouse = findViewById<ImageButton>(R.id.traditional_house)
        traditionalHouse.setOnClickListener {
            val moveHouse = Intent(this@MainActivity, ComingSoonActivity::class.java)
            startActivity(moveHouse)
        }
        Glide.with(this).load(R.drawable.traditional_house).error(R.drawable.ic_launcher_background).into(traditionalHouse)

        val traditionalClothing = findViewById<ImageButton>(R.id.traditional_clothing)
        traditionalClothing.setOnClickListener {
            val moveClothing = Intent(this@MainActivity, ComingSoonActivity::class.java)
            startActivity(moveClothing)
        }
        Glide.with(this).load(R.drawable.traditional_cloth).error(R.drawable.ic_launcher_background).into(traditionalClothing)

        val traditionalDances = findViewById<ImageButton>(R.id.traditional_dances)
        traditionalDances.setOnClickListener {
            val moveDances = Intent(this@MainActivity, ComingSoonActivity::class.java)
            startActivity(moveDances)
        }
        Glide.with(this).load(R.drawable.traditional_dances).error(R.drawable.ic_launcher_background).into(traditionalDances)

        val traditionalWeapon = findViewById<ImageButton>(R.id.traditional_weapon)
        traditionalWeapon.setOnClickListener {
            val moveWeapon = Intent(this@MainActivity, ComingSoonActivity::class.java)
            startActivity(moveWeapon)
        }
        Glide.with(this).load(R.drawable.traditional_weapon).error(R.drawable.ic_launcher_background).into(traditionalWeapon)

        val musicalInstrument = findViewById<ImageButton>(R.id.musical_instrument)
        musicalInstrument.setOnClickListener {
            val moveMusic = Intent(this@MainActivity, ComingSoonActivity::class.java)
            startActivity(moveMusic)
        }
        Glide.with(this).load(R.drawable.musical_instrument).error(R.drawable.ic_launcher_background).into(musicalInstrument)

        val traditionalEvent = findViewById<ImageButton>(R.id.traditional_event)
        traditionalEvent.setOnClickListener {
            val moveEvent = Intent(this@MainActivity, ComingSoonActivity::class.java)
            startActivity(moveEvent)
        }
        Glide.with(this).load(R.drawable.traditional_event).error(R.drawable.ic_launcher_background).into(traditionalEvent)

        val ethnicGroup = findViewById<ImageButton>(R.id.ethnic_group)
        ethnicGroup.setOnClickListener {
            val moveEthnic = Intent(this@MainActivity, ComingSoonActivity::class.java)
            startActivity(moveEthnic)
        }
        Glide.with(this).load(R.drawable.ethnic_group).error(R.drawable.ic_launcher_background).into(ethnicGroup)
    }
}
