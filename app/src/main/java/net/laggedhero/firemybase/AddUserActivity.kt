package net.laggedhero.firemybase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        userSubmit.setOnClickListener { addUser() }
    }

    private fun addUser() {
        when (userName.text.toString().isNullOrBlank()) {
            true -> Snackbar.make(userName, "Entry user name", Snackbar.LENGTH_LONG)
            false -> saveUserAndClose()
        }
    }

    private fun saveUserAndClose() {
        FirebaseDatabase.getInstance()
                .reference
                .child("users")
                .push()
                .setValue(User(userName.text.toString()))

        finish()
    }
}
