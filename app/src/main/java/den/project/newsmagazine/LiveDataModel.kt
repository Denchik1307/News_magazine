package den.project.newsmagazine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class LiveDataModel : ViewModel(){

    val filter: MutableLiveData<String> get() = _filter
    private val _filter = MutableLiveData<String>()
}