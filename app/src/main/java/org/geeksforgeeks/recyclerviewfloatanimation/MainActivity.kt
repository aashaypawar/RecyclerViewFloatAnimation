package org.geeksforgeeks.recyclerviewfloatanimation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_1)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        val mDataArray = mGenerateData()

        val mAdapter = MyAdapter(mDataArray)


        val mFloatingButton = findViewById<FloatingActionButton>(R.id.floating_button_1)
        mFloatingButton.setOnClickListener{
            val controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_right_to_left)
            mRecyclerView.layoutAnimation = controller
            mAdapter.notifyDataSetChanged()
            mRecyclerView.scheduleLayoutAnimation()
            mRecyclerView.adapter = mAdapter
        }

    }

    private fun mGenerateData(): ArrayList<String> {
        val mArrayList = arrayListOf<String>()
        for (i in 0..10) {
            mArrayList.add("Item $i")
        }
        return mArrayList
    }
}