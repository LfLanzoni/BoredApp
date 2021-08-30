package ar.android.lflanzoni.boredapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ar.android.lflanzoni.boredapp.R
import ar.android.lflanzoni.boredapp.presentation.BoredViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoredActivityFragment (): Fragment(R.layout.fragment_activity_bored) {
    private val boredViewModel : BoredViewModel by activityViewModels<BoredViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}