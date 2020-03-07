package com.sorianog.memelist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sorianog.memelist.R
import com.sorianog.memelist.util.loadImage
import com.sorianog.memelist.network.model.Meme
import kotlinx.android.synthetic.main.item_meme.view.*

class MemeListAdapter(var memes: List<Meme>) : RecyclerView.Adapter<MemeListAdapter.MemeViewHolder>() {

    class MemeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val memeImg = view.memeImage
        val memeName = view.memeName

        fun bind(meme: Meme) {
            memeImg.loadImage(meme.imgUrl)
            memeName.text = meme.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MemeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_meme, parent, false)
    )

    override fun getItemCount() = memes.size

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.bind(memes[position])
    }
}