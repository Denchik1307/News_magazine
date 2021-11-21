package den.project.newsmagazine.presentation

import den.project.newsmagazine.model.FiltersState
import den.project.newsmagazine.model.News

interface FeedViewModel {
    fun getNews():ArrayList<News>
    fun getFilteredNews(state: FiltersState): List<News>
}