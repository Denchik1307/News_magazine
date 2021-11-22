package den.project.newsmagazine.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.newsmagazine.R
import den.project.newsmagazine.ResourceTheme
import den.project.newsmagazine.databinding.FilterFragmentBinding
import den.project.newsmagazine.model.News

class NewsFilterAdapter : RecyclerView.Adapter<NewsFilterAdapter.NewsFilterHolder>() {
    private val newsList = ArrayList<News>()

    inner class NewsFilterHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = FilterFragmentBinding.bind(item)
        fun bindInit() {
            binding.radioAll.text = ResourceTheme.ALL.source
            binding.radioEconomic.text = ResourceTheme.ECONOMIC.source
            binding.radioGame.text = ResourceTheme.GAME.source
            binding.radioPolitic.text = ResourceTheme.POLITIC.source
            binding.radioTechnology.text = ResourceTheme.TECHNOLOGY.source
        }
    }

    companion object {
        fun newInstance() = NewsFilterAdapter()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFilterHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.filter_fragment, parent, false)
        return NewsFilterHolder(view)
    }

    override fun onBindViewHolder(holder: NewsFilterHolder, position: Int) {
        holder.bindInit()
        holder.binding.radioGroup.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun showNews(news: ArrayList<News>) {
        newsList.addAll(news)
        notifyDataSetChanged()
    }
}