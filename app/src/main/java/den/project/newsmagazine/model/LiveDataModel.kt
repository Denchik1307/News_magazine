package den.project.newsmagazine.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataModel : ViewModel() {

    val _newsFilter: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}