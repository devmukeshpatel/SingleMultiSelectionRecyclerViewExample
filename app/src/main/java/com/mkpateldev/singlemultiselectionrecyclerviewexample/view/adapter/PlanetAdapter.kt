package com.mkpateldev.singlemultiselectionrecyclerviewexample.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mkpateldev.singlemultiselectionrecyclerviewexample.R
import com.mkpateldev.singlemultiselectionrecyclerviewexample.databinding.ItemPlanetBinding
import com.mkpateldev.singlemultiselectionrecyclerviewexample.model.Planet
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.diffCallback.NormalRecyclerDiffUtilsCallback

class PlanetAdapter(private var ctx: Context, private var list: ArrayList<Planet>) :
    RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    fun setData(data: ArrayList<Planet>) {
        val diffCallback = NormalRecyclerDiffUtilsCallback(list, data)
        val diffCourses = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        diffCourses.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetAdapter.PlanetViewHolder {
        return PlanetViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(ctx),
                R.layout.item_planet, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PlanetAdapter.PlanetViewHolder, position: Int) {
        val planet = list[position]
        holder.setDetails(planet)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class PlanetViewHolder(binding: ItemPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var binding: ItemPlanetBinding

        init {
            this.binding = binding
        }

        fun setDetails(planet: Planet) {
            binding.txtName.text = planet.planetName
            binding.txtDistance.text = planet.distanceFromSun.toString()
            binding.txtGravity.text = planet.gravity.toString()
            binding.txtDiameter.text = planet.diameter.toString()

        }
    }
}