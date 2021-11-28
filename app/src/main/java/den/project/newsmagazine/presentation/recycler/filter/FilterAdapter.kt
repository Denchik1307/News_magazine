package den.project.newsmagazine.presentation.recycler.filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.newsmagazine.R

class FilterAdapter : RecyclerView.Adapter<FilterHolder>() {
    private val filterList = ArrayList<String>()

    companion object {
        fun newInstance() = FilterAdapter()
    }

    fun showFilter(filter: Set<String>) {
        filterList.clear()
        filterList.addAll(filter)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_fragment, parent, false)
        return FilterHolder(view)
    }

    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
        return holder.bind(filterList[position])
    }

    override fun getItemCount(): Int {
        return filterList.size
    }
}