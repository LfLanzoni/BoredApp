package ar.android.lflanzoni.boredapp.presentation

import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject
import ar.android.lflanzoni.boredapp.repository.Repository
import ar.android.lflanzoni.boredapp.repository.RepositoryImpl


class BoredViewModel  @ViewModelInject constructor( private val repo: Repository): ViewModel() {
}