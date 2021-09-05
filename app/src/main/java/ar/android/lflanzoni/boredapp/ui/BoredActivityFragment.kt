package ar.android.lflanzoni.boredapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ar.android.lflanzoni.boredapp.R
import ar.android.lflanzoni.boredapp.core.Resource
import ar.android.lflanzoni.boredapp.databinding.FragmentActivityBoredBinding
import ar.android.lflanzoni.boredapp.presentation.BoredViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoredActivityFragment() : Fragment(R.layout.fragment_activity_bored) {
    private val boredViewModel: BoredViewModel by activityViewModels()
    private lateinit var binding: FragmentActivityBoredBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentActivityBoredBinding.bind(view)

        boredViewModel.getBoredTask().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("TASK", "LOADING")
                }
                is Resource.Success -> {
                    result.data.body()?.let {
                        Log.d("TASK", it.activity)
                        binding.txtTask.text = it.activity
                        binding.txtType.text = it.type
                        binding.txtAccessibility.text = it.accessibility
                        binding.txtPrice.text = it.price.toString()
                        binding.txtParticipants.text = it.participants.toString()
                        binding.txtLink.text = it.link
                    }
                }
                is Resource.Failure -> {
                    Log.d("TASK", "ERROR")
                }
            }
        })
    }
}