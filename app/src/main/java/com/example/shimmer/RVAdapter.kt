package com.example.shimmer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shimmer.RVAdapter.*
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.*

class RVAdapter(private val models: ArrayList<Model>, private val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    var isShimmer = true

    companion object {
        private const val SHIMMER_ITEMS_NUMBER = 7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (isShimmer)
            holder.itemView.shimmerFrameLayout.startShimmer()
        else
            showUiWithData(holder)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showUiWithData(holder: ViewHolder) {
        holder.itemView.shimmerFrameLayout.stopShimmer()
        holder.itemView.shimmerFrameLayout.setShimmer(null)

        holder.itemView.titleTextView.background = null
        holder.itemView.titleTextView.text = models[holder.adapterPosition].title

        holder.itemView.descTextView.background = null
        holder.itemView.descTextView.text = models[holder.adapterPosition].desc

        holder.itemView.imageView.background = null
        holder.itemView.imageView.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.cat_icon
            )
        )
    }

    override fun getItemCount(): Int {
        return if (isShimmer) SHIMMER_ITEMS_NUMBER else models.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}