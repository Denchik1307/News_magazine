package den.project.newsmagazine.data

import den.project.newsmagazine.model.News

interface NewsRepository {
    fun getNews(): ArrayList<News>
}