package com.mkpateldev.singlemultiselectionrecyclerviewexample.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkpateldev.singlemultiselectionrecyclerviewexample.R
import com.mkpateldev.singlemultiselectionrecyclerviewexample.databinding.ActivityNormalRecyclerViewBinding
import com.mkpateldev.singlemultiselectionrecyclerviewexample.model.Planet
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.adapter.PlanetAdapter


class NormalRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNormalRecyclerViewBinding
    private var newList = true
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            finish()
        }
    }
    private var planetAdapter: PlanetAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_normal_recycler_view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Recycler View"
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        initViews()
    }

    private fun initViews() {
        binding.rvItem.layoutManager = LinearLayoutManager(this)
        planetAdapter = PlanetAdapter(this@NormalRecyclerViewActivity, createListData())
        binding.rvItem.adapter = planetAdapter
        binding.rvItem.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        binding.btnChangeData.setOnClickListener {
            if (newList) {
                newList = false
                planetAdapter!!.setData(createNewListData())
            } else {
                newList = true
                planetAdapter!!.setData(createListData())
            }
        }
    }

    private fun createNewListData(): ArrayList<Planet> {
        val planetList: ArrayList<Planet> = ArrayList()
        planetList.add(Planet("Earth", 150, 10, 12750))
        planetList.add(Planet("Jupiter", 778, 26, 143000))
        planetList.add(Planet("Marssss", 228, 4, 6800))
        planetList.add(Planet("Pluto", 5900, 1, 43434))
        planetList.add(Planet("Venus", 108, 9, 12750))
        planetList.add(Planet("Saturn", 1429, 11, 120000))
        planetList.add(Planet("Mercury", 58, 4, 4900))
        planetList.add(Planet("Neptune", 4500, 12, 50500))
        planetList.add(Planet("Uranus", 2870, 9, 52400))

        return planetList

    }

    private fun createListData(): ArrayList<Planet> {
        val planetList: ArrayList<Planet> = ArrayList()
        planetList.add(Planet("Earth", 150, 10, 12750))
        planetList.add(Planet("Jupiter", 778, 26, 143000))
        planetList.add(Planet("Mars", 228, 4, 6800))
        planetList.add(Planet("Pluto", 5900, 1, 2320))
        planetList.add(Planet("Venus", 108, 9, 12750))
        planetList.add(Planet("Saturn", 1429, 11, 120000))
        planetList.add(Planet("Mercury", 58, 4, 4900))
        planetList.add(Planet("Neptune", 4500, 12, 50500))
        planetList.add(Planet("Uranus", 2870, 9, 52400))

        return planetList

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}