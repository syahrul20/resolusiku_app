package com.sf.myresolution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sf.myresolution.room.entity.User
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ
 * Created By Fahmi on 10/01/21
 */
class UserListAdapter(private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserListAdapter.UserItemView>() {
    var onItemClickListener: (item: User) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserItemView(view)
    }

    override fun onBindViewHolder(holder: UserItemView, position: Int) {
        holder.itemView.textUser.text = userList[position].firstName
        holder.itemView.btnDelete.setOnClickListener {
            onItemClickListener(userList[position])
        }
    }

    override fun getItemCount(): Int = userList.size

    inner class UserItemView(view: View) : RecyclerView.ViewHolder(view) {

    }
}