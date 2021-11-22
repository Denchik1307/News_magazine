package den.project.newsmagazine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataModel : ViewModel() {

    val filter: MutableLiveData<String> get() = _filter
    private val _filter = MutableLiveData<String>()
}