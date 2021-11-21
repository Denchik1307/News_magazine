package den.project.newsmagazine.data

import den.project.newsmagazine.model.FiltersState
import den.project.newsmagazine.model.News

interface NewsRepository {
    fun getNews(): ArrayList<News>
    fun getFilteredNews(state: FiltersState): List<News>
}