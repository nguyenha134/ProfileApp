package com.example.appprofile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appprofile.model.WorkExperience
import com.example.appprofile.R

class WorkExperienceAdapter(private val lstKnlm:ArrayList<WorkExperience>) : RecyclerView.Adapter<WorkExperienceAdapter.MyViewHolder>() {
    class MyViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val nameCompany:TextView = view.findViewById(R.id.tvNameCompany)
        val position:TextView = view.findViewById(R.id.tvPosition)
        val description:TextView = view.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_knlv, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = lstKnlm[position]
        holder.nameCompany.text = currentItem.nameCompany
        holder.position.text = currentItem.position
        holder.description.text =  currentItem.description
    }

    override fun getItemCount(): Int {
       return lstKnlm.size
    }
}