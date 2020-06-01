package com.androidpemula.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidpemula.myrecyclerview.adapter.GridHeroAdapter
import com.androidpemula.myrecyclerview.adapter.ListHeroAdapter

class MainActivity : AppCompatActivity() {
    // Deklarasi Komponen View yang akan dimanipulasi
    private lateinit var rvHeroes: RecyclerView
    private var list: ArrayList<Hero> = arrayListOf() // list adalah key

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CastingView
        rvHeroes    = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        // Memanggil data yang telah dibuat di HeroesData
        list.addAll(HeroesData.listData)
        showRecyclerList() // Memanggil Function showRecyclerList() supaya tampil dihalaman utama
    }

    // Membuat Function showRecylerList
    private fun showRecyclerList() {
        rvHeroes.layoutManager  = LinearLayoutManager(this)
        val listHeroAdapter     = ListHeroAdapter(list)
        rvHeroes.adapter        = listHeroAdapter
    }

    // Membuat Function showRecyclerGrid
    private fun showRecyclerGrid() {
        rvHeroes.layoutManager  = GridLayoutManager(this, 2) // fungsi ini akan membangi 2 gambar
        val gridHeroAdapter     = GridHeroAdapter(list)
        rvHeroes.adapter        = gridHeroAdapter
    }

    // Menambahkan menu pada actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inisialisai menu
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Inisialisai Item yang ada pada menu
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        // Casting item menu
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList() // memanggil Function showRecyclerList di dalam menu
            }

            R.id.action_grid -> {
                showRecyclerGrid() // memanggil Function showRecyclerGrid di dalam menu
            }

            R.id.action_cardview -> {
                //kosong
            }
        }

    }
}