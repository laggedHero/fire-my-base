package net.laggedhero.firemybase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList.layoutManager = LinearLayoutManager(this)

        val query = FirebaseDatabase.getInstance().reference.child("users")
        val adapter = object : FirebaseRecyclerAdapter<User, UserViewHolder>(
                User::class.java, R.layout.user_list_item, UserViewHolder::class.java, query) {
            override fun populateViewHolder(viewHolder: UserViewHolder, model: User, position: Int) {
                viewHolder.bindTo(model)
            }
        }

        userList.adapter = adapter

        addUser.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddUserActivity::class.java))
        }
    }
}
