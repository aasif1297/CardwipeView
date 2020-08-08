package com.celeritassolution.cardwipeview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.celeritassolution.cardwipeview.R
import com.celeritassolution.cardwipeview.model.PetsModel
import java.util.*

class PetAdapter(
    private val models: ArrayList<PetsModel>,
    private val context: Context
) : PagerAdapter() {
//    private var layoutInflater: LayoutInflater? = null
    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        layoutInflater = LayoutInflater.from(context)
//        val view = layoutInflater.inflate(R.layout.item, container, false)
        val mView = LayoutInflater.from(context).inflate(R.layout.item,container,false)
        val imageView: ImageView
        val title: TextView
        val desc: TextView
        imageView = mView.findViewById(R.id.image)
        title = mView.findViewById(R.id.title)
        desc = mView.findViewById(R.id.txt_des)
        imageView.setImageResource(models[position].image)
        title.text = models[position].title
        desc.text = models[position].desc
        container.addView(mView, 0)
        return mView
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as View)
    }

}