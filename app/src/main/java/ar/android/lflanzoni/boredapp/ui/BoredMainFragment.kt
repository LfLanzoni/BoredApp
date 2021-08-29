package ar.android.lflanzoni.boredapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ar.android.lflanzoni.boredapp.R
import ar.android.lflanzoni.boredapp.databinding.FragmentMainBoredBinding

class BoredMainFragment: Fragment(R.layout.fragment_main_bored) {
    private lateinit var binding: FragmentMainBoredBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBoredBinding.bind(view)

        binding.btnRandom.setOnClickListener {
            view.findNavController().navigate(R.id.action_boredMainFragment_to_boredActivityFragment)
        }
        binding.btnCategory.setOnClickListener {
            view.findNavController().navigate(R.id.action_boredMainFragment_to_boredCategoriesFragment)
        }
    }
}