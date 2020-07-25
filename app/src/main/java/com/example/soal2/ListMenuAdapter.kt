package com.example.soal2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class ListMenuAdapter(private val listMenu: ArrayList<Menus>) : RecyclerView.Adapter<ListMenuAdapter.ListViewHolder>() {

    private lateinit var onItemCLick: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivMenu: CircleImageView = itemView.findViewById(R.id.ivMenu)
        var tvMenuName: TextView = itemView.findViewById(R.id.tvMenuName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_per_menu, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val menu = listMenu[position]

        Glide.with(holder.itemView.context)
            .load(menu.img)
            .apply(RequestOptions().override(105, 105))
            .into(holder.ivMenu)

        holder.tvMenuName.text = menu.menuName
        holder.itemView.setOnClickListener { onItemCLick.onItemClicked(listMenu[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Menus)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemCLick = onItemClickCallback
    }
}