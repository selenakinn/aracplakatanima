package com.example.kullaniciapp.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kullaniciapp.R

class BildirimAdapter(
    private val bildirimList: MutableList<Bildirim>
) : RecyclerView.Adapter<BildirimAdapter.BildirimViewHolder>() {

    class BildirimViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textMessage: TextView = itemView.findViewById(R.id.textMessage)
        val textTime: TextView = itemView.findViewById(R.id.textTime)
        val imageIcon: ImageView = itemView.findViewById(R.id.imageIcon)
        val imageClose: ImageButton = itemView.findViewById(R.id.imageClose)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BildirimViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bildirim_item, parent, false)
        return BildirimViewHolder(view)
    }

    override fun onBindViewHolder(holder: BildirimViewHolder, position: Int) {
        val bildirim = bildirimList[position]
        holder.textMessage.text = bildirim.mesaj
        holder.textTime.text = bildirim.zaman

        holder.imageIcon.setImageResource(R.drawable.ic_bildirim1)

        val blinkAnimation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.blink)
        holder.imageIcon.startAnimation(blinkAnimation)

        holder.imageClose.setOnClickListener {
            bildirimList.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }
    }


    override fun getItemCount(): Int = bildirimList.size
}
