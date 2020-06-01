package com.androidpemula.myrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidpemula.myrecyclerview.Hero
import com.androidpemula.myrecyclerview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/*NOTE:
* Sebaiknya melakukan resolve dengan cara manual
* */

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Inisialisasi View yang ada di dalam layout Item_row_hero.xml
        var tvName: TextView    = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView  = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder { // perhatikan ViewGroupnya
        // Inisialisasi Layout item_grid_hero yang ada di dalam layout Item_grid_hero.xml
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        // OnBind
        val  hero   = listHero[position]

        // Memasukan gambar
        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        // Memasukan TextView
        holder.tvName.text   = hero.name
        holder.tvDetail.text = hero.detail
    }

}