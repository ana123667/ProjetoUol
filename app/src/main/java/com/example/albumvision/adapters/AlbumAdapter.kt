package com.example.albumvision.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.albumvision.R
import com.example.albumvision.model.Album

class AlbumAdapter(private val onItemClick: (Album) -> Unit) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private var albumList: List<Album> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(albums: List<Album>) {
        albumList = albums
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.bind(album)
        holder.itemView.setOnClickListener { onItemClick(album) }
    }

    override fun getItemCount(): Int = albumList.size

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val albumTitleTextView: TextView = itemView.findViewById(R.id.albumTitleTextView)

        fun bind(album: Album) {
            albumTitleTextView.text = album.title
        }
    }
}
