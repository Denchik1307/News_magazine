package den.project.newsmagazine.domain

import den.project.newsmagazine.model.FiltersState
import den.project.newsmagazine.model.News

interface GetNewsUseCase {
    fun getNews(): ArrayList<News>
    fun getFilteredNews(state: FiltersState): List<News>
}