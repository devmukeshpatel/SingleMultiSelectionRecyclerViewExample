package com.mkpateldev.singlemultiselectionrecyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mkpateldev.singlemultiselectionrecyclerviewexample.databinding.ActivityMainBinding
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.activity.CardRecyclerViewActivity
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.activity.MultipleSelectionActivity
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.activity.MultipleViewTypeActivity
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.activity.NormalRecyclerViewActivity
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.activity.SingleSelectionActivity
import com.mkpateldev.singlemultiselectionrecyclerviewexample.view.activity.SwipeSelectionActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        binding.btnNormal.setOnClickListener(this)
        binding.btnSingle.setOnClickListener(this)
        binding.btnMultiple.setOnClickListener(this)
        binding.btnSwipe.setOnClickListener(this)
        binding.btnCardView.setOnClickListener(this)
        binding.btnMultipleView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnNormal -> {
                startActivity(Intent(this@MainActivity, NormalRecyclerViewActivity:: class.java))
            }

            R.id.btnSingle -> {
                startActivity(Intent(this@MainActivity, SingleSelectionActivity::class.java))
            }

            R.id.btnMultiple -> {
                startActivity(Intent(this@MainActivity, MultipleSelectionActivity::class.java))
            }

            R.id.btnSwipe -> {
                startActivity(Intent(this@MainActivity, SwipeSelectionActivity::class.java))
            }

            R.id.btnCardView -> {
                startActivity(Intent(this@MainActivity, CardRecyclerViewActivity::class.java))
            }

            R.id.btnMultipleView -> {
                startActivity(Intent(this@MainActivity, MultipleViewTypeActivity::class.java))
            }
        }
    }
}