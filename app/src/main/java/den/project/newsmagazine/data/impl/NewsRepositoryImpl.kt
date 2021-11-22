package den.project.newsmagazine.data.impl

import den.project.newsmagazine.data.NewsRepository
import den.project.newsmagazine.model.News
import den.project.newsmagazine.test.testNews

class NewsRepositoryImpl : NewsRepository {
    override fun getNews(): ArrayList<News> {
        return testNews
    }
}