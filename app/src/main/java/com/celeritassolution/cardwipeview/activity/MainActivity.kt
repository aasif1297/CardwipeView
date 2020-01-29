package com.celeritassolution.cardwipeview.activity

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.celeritassolution.cardwipeview.R
import com.celeritassolution.cardwipeview.adapter.PetAdapter
import com.celeritassolution.cardwipeview.model.PetsModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: PetAdapter
    private lateinit var models: ArrayList<PetsModel>
    private lateinit var viewPager: ViewPager
    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        sliderDotspanel = findViewById(R.id.slider_dots)

        models = ArrayList()
        models.add(PetsModel(R.drawable.dummy_image,"Dobby", "Kutta"))
        models.add(PetsModel(R.drawable.dummy_image,"Kitto", "billi"))
        models.add(PetsModel(R.drawable.dummy_image,"Cozmo", "Lambardor"))
        models.add(PetsModel(R.drawable.dummy_image,"Tiger", "German Shepherd"))
        models.add(PetsModel(R.drawable.dummy_image,"Husky", "Husky"))
        models.add(PetsModel(R.drawable.dummy_image,"Cat", "Unknown"))

        adapter = PetAdapter(models, this@MainActivity)
        viewPager.adapter = adapter



        viewPager.setPadding(30, 0, 30, 0)
        dotscount = adapter.count

        val dots = arrayOfNulls<ImageView>(dotscount)

        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.non_active_dot))
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot))

        viewPager.setOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int){}

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.non_active_dot))
                }
                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.active_dot))
            }
        })

    }
}
