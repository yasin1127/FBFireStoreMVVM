package com.example.fbfirestoremvvm.Adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fbfirestoremvvm.Data.Data
import com.example.fbfirestoremvvm.R

class DataAdapter(private var data:List<Data>, private val itemClickListener:ItemClickListener): RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val stuid = itemView.findViewById<TextView>(R.id.idTxt)
        val name = itemView.findViewById<TextView>(R.id.nameTxt)
        val email = itemView.findViewById<TextView>(R.id.emailTxt)
        val subject = itemView.findViewById<TextView>(R.id.subjectTxt)
        val birthdate = itemView.findViewById<TextView>(R.id.birthdateTxt)
        val edit = itemView.findViewById<ImageButton>(R.id.editBtn)
        val delete = itemView.findViewById<ImageButton>(R.id.deleteBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.stuid.text= item.stuid
        holder.name.text= item.name
        holder.email.text= item.email
        holder.subject.text= item.subject
        holder.birthdate.text = item.birthday

        holder.edit.setOnClickListener {
            itemClickListener.onEditItemClick(item)
        }
        holder.delete.setOnClickListener {
            itemClickListener.onDeleteItemClick(item)
        }
    }

    fun updateData(newdata: List<Data>) {
        this.data = newdata
        notifyDataSetChanged()

    }

}

interface ItemClickListener {
    fun onEditItemClick(data: Data)
    fun onDeleteItemClick(data: Data)

}
