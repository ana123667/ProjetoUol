package com.example.albumvision.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.albumvision.R
import com.example.albumvision.model.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter : BaseAdapter() {

    private var photos: List<Photo> = emptyList()

    fun setData(newPhotos: List<Photo>) {
        photos = newPhotos
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return photos.size
    }

    override fun getItem(position: Int): Any {
        return photos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_photo, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val photo = getItem(position) as Photo
        Picasso.get().load(photo.url).into(holder.photoImageView)

        return view
    }

    private class ViewHolder(view: View) {
        val photoImageView: ImageView = view.findViewById(R.id.photoImageView)
    }
}
