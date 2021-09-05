package ar.android.lflanzoni.boredapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ar.android.lflanzoni.boredapp.R
import ar.android.lflanzoni.boredapp.core.Resource
import ar.android.lflanzoni.boredapp.data.model.BoredTask
import ar.android.lflanzoni.boredapp.databinding.FragmentActivityBoredBinding
import ar.android.lflanzoni.boredapp.presentation.BoredViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoredActivityFragment : Fragment(R.layout.fragment_activity_bored) {
    private val boredViewModel: BoredViewModel by activityViewModels()
    private lateinit var binding: FragmentActivityBoredBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentActivityBoredBinding.bind(view)

        boredViewModel.getBoredTask().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("TASK", "LOADING")
                    binding.progressBar.visibility = View.VISIBLE
                    binding.cardContainer.visibility = View.GONE
                }
                is Resource.Success -> {
                    result.data.body()?.let {
                        Log.d("TASK", it.activity)
                        setUpView(it)
                    }
                }
                is Resource.Failure -> {
                    Log.d("TASK", "ERROR")
                }
            }
        })
    }

    private fun setUpView(task: BoredTask) {
        translateTask(task.activity)
        translateType(task.type)
        if(task.accessibility.isNotEmpty()){
            binding.txtAccessibility.text = task.accessibility
        }else{
            binding.txtAccessibility.visibility = View.GONE
            binding.txtTitleAccessibility.visibility = View.GONE
        }
        if(task.price > 0.0f){
            binding.txtPrice.text = task.price.toString()
        }else{
            binding.txtPrice.visibility = View.GONE
            binding.txtTitlePrice.visibility = View.GONE
        }
        if(task.participants != 1){
            binding.txtParticipants.text = task.participants.toString()
        }else{
            binding.txtParticipants.visibility = View.GONE
            binding.txtTitleParticipants.visibility = View.GONE
        }
        if(task.link.isNotEmpty()){
            binding.txtLink.text = task.link
        }else{
            binding.txtLink.visibility = View.GONE
            binding.txtTitleLink.visibility = View.GONE
        }
    }

    private fun translateType(type: String){
        boredViewModel.translateText(type).observe(viewLifecycleOwner,{ result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("TRANSLATE TYPE", "LOADING")
                    binding.progressBar.visibility = View.VISIBLE
                    binding.cardContainer.visibility = View.GONE
                }
                is Resource.Success ->{
                    Log.d("TRANSLATE TYPE", result.data.body()!!.translatedText)
                    binding.txtType.text = result.data.body()!!.translatedText
                    binding.progressBar.visibility = View.GONE
                    binding.cardContainer.visibility = View.VISIBLE
                }
                is Resource.Failure ->{
                    Log.d("TRANSLATE TYPE", "ERROR")
                    binding.txtType.text = type
                }

            }
        })
    }

    private fun translateTask(task: String){
        boredViewModel.translateText(task).observe(viewLifecycleOwner,{ result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("TRANSLATE TASK", "LOADING")
                    binding.progressBar.visibility = View.VISIBLE
                    binding.cardContainer.visibility = View.GONE
                }
                is Resource.Success ->{
                    Log.d("TRANSLATE TASK", result.data.body()!!.translatedText)
                    binding.txtTask.text = result.data.body()!!.translatedText
                    binding.progressBar.visibility = View.GONE
                    binding.cardContainer.visibility = View.VISIBLE
                }
                is Resource.Failure ->{
                    Log.d("TRANSLATE TASK", "ERROR")
                    binding.txtTask.text = task
                }

            }
        })
    }
}