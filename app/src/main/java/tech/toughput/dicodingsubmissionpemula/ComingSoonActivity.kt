package tech.toughput.dicodingsubmissionpemula

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class ComingSoonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coming_soon)

        val underCons = findViewById<ImageView>(R.id.under_construction)
        Glide.with(this).load(R.drawable.comingsoon_img).into(underCons)
    }
}
