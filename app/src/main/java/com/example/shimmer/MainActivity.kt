package com.example.shimmer

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val delayMillis = 5000L;
    }

    private val models: ArrayList<Model> = getTestCollection()
    private val adapter: RVAdapter = RVAdapter(models, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.hasFixedSize()
        recyclerView.adapter = adapter
        dataLoad()
    }

    private fun dataLoad() {
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                models
                adapter.isShimmer = false
                adapter.notifyDataSetChanged()
            }, delayMillis)
        }
    }

    private fun getTestCollection(): ArrayList<Model> {
        val models: java.util.ArrayList<Model> = java.util.ArrayList()
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        models.add(
            Model(
                "Cat name - Picky",
                "Cat description - She is quite old for a cat. She is eleven years old. Her back is black and her belly and chest are white."
            )
        )
        return models
    }
}