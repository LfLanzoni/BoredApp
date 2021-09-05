package ar.android.lflanzoni.boredapp.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import ar.android.lflanzoni.boredapp.repository.Repository
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData
import ar.android.lflanzoni.boredapp.core.Resource

class BoredViewModel  @ViewModelInject constructor( private val repo: Repository): ViewModel() {

    fun getBoredTask() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getBoredActivity()))
        }
        catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun translateText(text: String) = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.translateText(text)))
        }
        catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}