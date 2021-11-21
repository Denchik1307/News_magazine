package den.project.newsmagazine.domain.impl

import den.project.newsmagazine.data.NewsRepository
import den.project.newsmagazine.domain.GetNewsUseCase
import den.project.newsmagazine.model.FiltersState
import den.project.newsmagazine.model.News

class GetNewsUseCaseImpl(private val repository: NewsRepository) : GetNewsUseCase {

    override fun getNews(): ArrayList<News> {
        return repository.getNews()
    }

    override fun getFilteredNews(state: FiltersState): List<News> {
        return repository.getFilteredNews(state);
    }

}