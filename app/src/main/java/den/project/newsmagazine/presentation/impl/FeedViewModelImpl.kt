package den.project.newsmagazine.presentation.impl

import den.project.newsmagazine.domain.GetNewsUseCase
import den.project.newsmagazine.model.FiltersState
import den.project.newsmagazine.model.News
import den.project.newsmagazine.presentation.FeedViewModel

class FeedViewModelImpl(private val useCase: GetNewsUseCase) : FeedViewModel {
    override fun getNews(): ArrayList<News> {
        return useCase.getNews()
    }
    override fun getFilteredNews(state: FiltersState): List<News> {
        return useCase.getFilteredNews(state)
    }
}