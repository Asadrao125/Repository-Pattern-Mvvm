package com.technado.repositorypatternmvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technado.repositorypatternmvvm.adapters.RecyclerViewAdapter
import com.technado.repositorypatternmvvm.models.RecyclerData
import com.technado.repositorypatternmvvm.models.RecyclerList
import com.technado.repositorypatternmvvm.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var button: Button
    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        button = findViewById(R.id.button)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Api Calling", Toast.LENGTH_SHORT).show()
            viewModel.getRecyclerListObserver().observe(this, Observer<RecyclerList> {
                if (it != null) {
                    adapter = RecyclerViewAdapter(this, it.items)
                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            })
            viewModel.makeApiCall()
        })
    }
}