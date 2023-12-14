package com.mkpateldev.singlemultiselectionrecyclerviewexample.view.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.mkpateldev.singlemultiselectionrecyclerviewexample.model.Planet

class NormalRecyclerDiffUtilsCallback(private val oldList: ArrayList<Planet>, private val newList: ArrayList<Planet>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].planetName == newList[newItemPosition].planetName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPlanet = oldList[oldItemPosition]
        val newPlanet = newList[newItemPosition]

        return (oldPlanet.planetName == newPlanet.planetName &&
                oldPlanet.distanceFromSun == newPlanet.distanceFromSun &&
                oldPlanet.gravity == newPlanet.gravity &&
                oldPlanet.diameter == newPlanet.diameter)
    }
}