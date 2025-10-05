package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable List for storing all the List data
    private val cats = mutableListOf<CatModel>()

    // A function to set the mutable list
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)

        // This is used to tell the adapter that there's a data change in the mutable list
        notifyDataSetChanged()
    }

    // A view holder is used to bind the data to the layout views
    // onCreateViewHolder is instantiating the view holder itself
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader, onClickListener)
    }

    // This is used to get the number of data/item in the list
    override fun getItemCount(): Int = cats.size

    // This is used to bind data to each layout views
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // The holder parameter stores our previously created ViewHolder
        // The holder.bindData function is declared in the CatViewHolder
        holder.bindData(cats[position])
    }

    //Declare an onClickListener interface
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }
}
