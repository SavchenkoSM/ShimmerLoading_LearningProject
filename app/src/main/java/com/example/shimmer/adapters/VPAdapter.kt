package com.example.shimmer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.example.shimmer.R
import com.example.shimmer.models.Model
import kotlinx.android.synthetic.main.card_item.view.*

class VPAdapter(private val context: Context, private val models: ArrayList<Model>) :
    PagerAdapter() {


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return models.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(context).inflate(R.layout.card_item, container, false)

        val model = models[position]
        val title = model.title
        val desc = model.desc
        val date = model.date
        val image = model.image

        view.catNameTextView.text = title
        view.catDescTextView.text = desc
        view.dateOfAddingCatTextView.text = date
        view.bannerImageView.setImageResource(image)

        view.setOnClickListener {
            Toast.makeText(context, "$title \n $desc \n $date", Toast.LENGTH_SHORT).show()
        }

        container.addView(view, position)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}