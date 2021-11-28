package den.project.newsmagazine.presentation.recycler.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import den.project.newsmagazine.databinding.NewsFragmentBinding
import den.project.newsmagazine.model.NewsData

class NewsHolder(item: View) : RecyclerView.ViewHolder(item) {
    val binding = NewsFragmentBinding.bind(item)

    fun bind(newsData: NewsData)= with(binding) {
        nameNews.text = newsData.title
        textNews.text = newsData.text
        bodyAuthorNews.text = newsData.author
        dataNews.text = newsData.data
        titleNews.text = newsData.topic
    }
}