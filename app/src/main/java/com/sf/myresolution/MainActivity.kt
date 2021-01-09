package com.sf.myresolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sf.myresolution.room.entity.User
import com.sf.myresolution.room.roomInstance.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db: UserDatabase
    lateinit var userListAdapter: UserListAdapter
    private var userList: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpDatabase()
    }

    private fun setUpDatabase() {
        db = UserDatabase.getInstance(this)
        getData(db.userDao().loadUser())

        setUpListener()
    }

    private fun getData(user: Array<User>) {
        userList.addAll(user)
        userListAdapter = UserListAdapter(userList)
        recyclerViewUser.adapter = userListAdapter

        userListAdapter.onItemClickListener = { item ->
            userList.remove(item)
            db.userDao().deleteUser(item.id)
            userListAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpListener() {
        btnSubmit.setOnClickListener {
            if (!edUser.text.isNullOrEmpty()) {
                val data = User(firstName = edUser.text.toString())
                with(db.userDao()) {
                    insertUser(data)
                    getData(db.userDao().loadUser())
                }
            } else {
                Toast.makeText(this, "Field kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}