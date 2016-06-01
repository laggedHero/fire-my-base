package net.laggedhero.firemybase

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.user_list_item.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(user: User) {
        itemView.userName.text = user.username
    }
}