package com.example.shimmer

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.shimmer.adapters.RVAdapter
import com.example.shimmer.adapters.VPAdapter
import com.example.shimmer.models.Model
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val delayMillis = 5000L
    }

    private lateinit var actionBar: ActionBar
    private lateinit var viewPagerAdapter: VPAdapter

    private val models: ArrayList<Model> = getTestCollection()
    private val adapter: RVAdapter = RVAdapter(models, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = this.supportActionBar!!
        loadCardsPV()
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // Change ActionBar title
                val title = models[position].title
                actionBar.title = title
            }

            override fun onPageSelected(position: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
        })

        //recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.hasFixedSize()
        recyclerView.adapter = adapter
        loadDataRV()
    }

    private fun loadCardsPV() {
        viewPagerAdapter = VPAdapter(this, models)
        viewPager.adapter = viewPagerAdapter
        viewPager.setPadding(100, 0, 100, 0)
    }

    private fun loadDataRV() {
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                models
                adapter.isShimmer = false
                adapter.notifyDataSetChanged()
            }, delayMillis)
        }
    }

    private fun getTestCollection(): ArrayList<Model> {
        val models: ArrayList<Model> = ArrayList()
        models.add(
            Model(
                "Picky",
                "She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white.",
                "May 22, 2021",
                R.drawable.cat1
            )
        )
        models.add(
            Model(
                "Lucky",
                "She is beautiful and fluffy cat with a strong character.",
                "May 23, 2021",
                R.drawable.cat2
            )
        )
        models.add(
            Model(
                "Garry",
                "He is a young, one year old. He is multicolor cat.",
                "May 24, 2021",
                R.drawable.cat3
            )
        )
        models.add(
            Model(
                "Zuzya",
                "She is a young and interesting cat.",
                "May 25, 2021",
                R.drawable.cat4
            )
        )
        models.add(
            Model(
                "Maurizio",
                "The best cat ever!!!",
                "May 26, 2021",
                R.drawable.cat5
            )
        )
        return models
    }
}