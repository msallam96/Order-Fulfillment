package com.ucs.picker.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ucs.picker.R
import com.ucs.picker.data.User
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(private val context: Context, private val usersList: List<User>) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        with(holder.itemView) {
            tvName.text = usersList[position].name
            tvEmail.text = usersList[position].email
            Glide.with(context).load(usersList[position].avatar)
                .into(ivAvatar)

        }
    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}