package ar.android.lflanzoni.boredapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ar.android.lflanzoni.boredapp.R
import ar.android.lflanzoni.boredapp.databinding.FragmentCategoriesBoredBinding
import ar.android.lflanzoni.boredapp.ui.adapter.AdapterCategories

class BoredCategoriesFragment(): Fragment(R.layout.fragment_categories_bored) {
    val categories = listOf("education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork")
    private lateinit var binding: FragmentCategoriesBoredBinding
    private  lateinit var adapter: AdapterCategories


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoriesBoredBinding.bind(view)
        adapter = AdapterCategories(categories)
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCategories.adapter = adapter
    }
}