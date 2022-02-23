package com.technado.repositorypatternmvvm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.technado.repositorypatternmvvm.MainActivity
import com.technado.repositorypatternmvvm.R
import com.technado.repositorypatternmvvm.models.RecyclerData

class RecyclerViewAdapter(var context: MainActivity, var items: ArrayList<RecyclerData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = items.get(position).name
        holder.tvDescription.text = items.get(position).description
        Picasso.get().load(items.get(position).owner.avatar_url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView
        var tvDescription: TextView
        var image: ImageView

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvDescription = itemView.findViewById(R.id.tvDescription)
            image = itemView.findViewById(R.id.image)
        }
    }
}