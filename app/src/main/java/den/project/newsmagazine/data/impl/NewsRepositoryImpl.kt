package den.project.newsmagazine.data.impl

import den.project.newsmagazine.data.NewsRepository
import den.project.newsmagazine.model.FiltersState
import den.project.newsmagazine.model.News
import den.project.newsmagazine.test.testNews

class NewsRepositoryImpl : NewsRepository {
    override fun getNews(): ArrayList<News> {
        return testNews
    }
    override fun getFilteredNews(state: FiltersState): List<News> {
        return testNews.filter {  news ->
            var passed = true

            state.comparators.forEach { comparator ->
                if(!comparator(news)) passed = false
            }

            passed
        }
    }

}