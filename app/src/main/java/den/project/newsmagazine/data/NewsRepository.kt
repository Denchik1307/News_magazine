package den.project.newsmagazine.data

import den.project.newsmagazine.model.NewsData

interface NewsRepository {
    fun getNews(): ArrayList<NewsData>
}