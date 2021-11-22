package den.project.newsmagazine.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.newsmagazine.R
import den.project.newsmagazine.databinding.NewsFragmentBinding
import den.project.newsmagazine.model.News

class NewsFragmentAdapter : RecyclerView.Adapter<NewsFragmentAdapter.NewsFragmentHolder>() {
    private val newsList = ArrayList<News>()

    inner class NewsFragmentHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = NewsFragmentBinding.bind(item)
        fun bind(news: News) {
            binding.nameNews.text = news.title
            binding.textNews.text = news.text
            binding.bodyAuthorNews.text = news.author
            binding.dataNews.text = news.data
            binding.titleNews.text = news.topic
        }
    }

    companion object {
        fun newInstance() = NewsFragmentAdapter()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFragmentHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_fragment, parent, false)
        return NewsFragmentHolder(view)
    }

    override fun onBindViewHolder(holder: NewsFragmentHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun showNews(news: ArrayList<News>) {
        newsList.addAll(news)
        notifyDataSetChanged()
    }
}