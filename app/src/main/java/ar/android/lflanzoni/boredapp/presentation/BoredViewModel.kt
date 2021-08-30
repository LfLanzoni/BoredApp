package ar.android.lflanzoni.boredapp.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import ar.android.lflanzoni.boredapp.repository.Repository

class BoredViewModel  @ViewModelInject constructor( private val repo: Repository): ViewModel() {

}