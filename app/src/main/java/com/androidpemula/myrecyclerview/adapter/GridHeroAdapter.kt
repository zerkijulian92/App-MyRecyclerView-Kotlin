package com.androidpemula.myrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.androidpemula.myrecyclerview.Hero
import com.androidpemula.myrecyclerview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/*NOTE:
* Sebaiknya melakukan resolve dengan cara manual
* */

class GridHeroAdapter(val listHeroes: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Inisialisasi ImageView
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        // Inisialisasi Layout item_grid_hero yang ada di dalam layout Item_grid_hero.xml
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_hero, viewGroup, false)
        return GridViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
       // onBind
        Glide.with(holder.itemView.context)
            .load(listHeroes[position].photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)
    }
}