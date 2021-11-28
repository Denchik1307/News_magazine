package den.project.newsmagazine.data.impl

import den.project.newsmagazine.data.NewsRepository
import den.project.newsmagazine.model.NewsData
import den.project.newsmagazine.test.TEST_NEWS

class NewsRepositoryImpl : NewsRepository {
    override fun getNews(): ArrayList<NewsData> {
        return TEST_NEWS
    }
}