package com.example.jason_anmp_160420070.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jason_anmp_160420070.databinding.CarListItemBinding
import com.example.jason_anmp_160420070.model.Car


class CarListAdapter(val carList:ArrayList<Car>): RecyclerView.Adapter<CarListAdapter.CarViewHolder>(){
    class CarViewHolder(var binding: CarListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CarViewHolder {
        val binding = CarListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.binding.txtMake.text = carList[position].make
        holder.binding.txtModel.text = carList[position].model
        holder.binding.txtYear.text = carList[position].year.toString()
    }

    fun updateCarsList(newCarList: ArrayList<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}
