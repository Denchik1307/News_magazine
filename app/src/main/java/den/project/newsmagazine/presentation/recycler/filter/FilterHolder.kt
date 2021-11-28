package den.project.newsmagazine.presentation.recycler.filter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import den.project.newsmagazine.databinding.FilterFragmentBinding

class FilterHolder(item: View) : RecyclerView.ViewHolder(item) {
    val binding = FilterFragmentBinding.bind(item)

    fun bind(filter: String) {
        binding.radioButton.text = filter
    }
}