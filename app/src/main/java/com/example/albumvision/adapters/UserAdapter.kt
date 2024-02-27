package com.example.albumvision.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.albumvision.R
import com.example.albumvision.model.User

class UserAdapter : BaseAdapter() {

    private var users: List<User> = emptyList()

    fun setData(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_user, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val user = getItem(position) as User
        holder.userNameTextView.text = user.name

        return view
    }

    private class ViewHolder(view: View) {
        val userNameTextView: TextView = view.findViewById(R.id.userNameTextView)
    }
}