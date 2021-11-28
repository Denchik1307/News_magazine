package den.project.newsmagazine.presentation.recycler.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.newsmagazine.R
import den.project.newsmagazine.model.NewsData

class NewsAdapter : RecyclerView.Adapter<NewsHolder>() {
    private val newsList = ArrayList<NewsData>()

    companion object {
        fun newInstance() = NewsAdapter()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_fragment, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun showNews(newsData: ArrayList<NewsData>) {
        newsList.clear()
        newsList.addAll(newsData)
        notifyDataSetChanged()
    }
}