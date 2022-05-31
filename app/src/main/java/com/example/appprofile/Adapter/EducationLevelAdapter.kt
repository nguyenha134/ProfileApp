package com.example.appprofile.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appprofile.Model.EducationLevel
import com.example.appprofile.R


class EducationLevelAdapter(private val lstHv: ArrayList<EducationLevel>) :
    RecyclerView.Adapter<EducationLevelAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dong_hocvan, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = lstHv[position]
        holder.tvNameSchool.text = currentItem.nameSchool
        holder.tvCertificate.text = currentItem.certificate
    }

    override fun getItemCount(): Int {
        return lstHv.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNameSchool: TextView = view.findViewById(R.id.tvNameSchool)
        val tvCertificate: TextView = view.findViewById(R.id.tvCertificate)

    }


}