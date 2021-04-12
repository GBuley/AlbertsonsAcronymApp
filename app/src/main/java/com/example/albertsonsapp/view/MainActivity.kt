package com.example.albertsonsapp.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albertsonsapp.adapter.AcronymAdapter
import com.example.albertsonsapp.databinding.ActivityMainBinding
import com.example.albertsonsapp.utils.snack
import com.example.albertsonsapp.viewmodels.AcronymViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: AcronymViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val acronymAdapter by lazy { AcronymAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initViews()
        setupObservers()
    }

    private fun initViews() = with(binding) {
        rvMeanings.layoutManager = LinearLayoutManager(root.context)
        rvMeanings.adapter = acronymAdapter
        btnSearch.setOnClickListener(::searchAcronym)
    }

    private fun setupObservers() = viewModel.run {
        lfList.observe(this@MainActivity) { acronymAdapter.submitList(it) }
        error.observe(this@MainActivity) { errorMsg -> binding.root.snack(errorMsg) }
    }

    private fun searchAcronym(btn: View) {
        binding.etAcronym.text.toString().run {
            if (isNotBlank()) viewModel.getAcronym(this)
            else binding.root.snack("Please enter a valid acronym")
        }
    }

}