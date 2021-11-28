package den.project.newsmagazine

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.arraySetOf
import androidx.recyclerview.widget.LinearLayoutManager
import den.project.newsmagazine.data.NewsRepository
import den.project.newsmagazine.data.impl.NewsRepositoryImpl
import den.project.newsmagazine.databinding.ActivityMainBinding
import den.project.newsmagazine.model.NewsData
import den.project.newsmagazine.presentation.recycler.filter.FilterAdapter
import den.project.newsmagazine.presentation.recycler.news.NewsAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val feedNews: NewsRepository = NewsRepositoryImpl()
    private var sortedNews = feedNews.getNews()
    private var shareFilter = arraySetOf<String>()
    private val adapterNews = NewsAdapter()
    private val adapterFilter = FilterAdapter.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            showNews(sortedNews)
        }
    }

    private fun showNews(newsData: ArrayList<NewsData>) {
        binding.apply {
            fragmentNewsHolder.layoutManager = LinearLayoutManager(this@MainActivity)
            fragmentNewsHolder.adapter = adapterNews
            adapterNews.showNews(newsData)
            val show = getFilters(ResourceFilter.AUTHOR, sortedNews)
            binding.sort.setOnClickListener {
                showFilter(show)
                Toast.makeText(applicationContext, "$show", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showFilter(filterData: Set<String>) {
        binding.apply {
            fragmentFilterHolder.layoutManager = LinearLayoutManager(this@MainActivity)
            fragmentFilterHolder.adapter = adapterFilter
            adapterFilter.showFilter(filterData)
        }
    }

    private fun getFilters(filterTeg: ResourceFilter, news: ArrayList<NewsData>): Set<String> {
        shareFilter.clear()
        when (filterTeg) {
            ResourceFilter.TOPIC -> news.forEach { shareFilter.add(it.topic) }
            ResourceFilter.AUTHOR -> news.forEach { shareFilter.add(it.author) }
            ResourceFilter.DATA -> news.forEach { shareFilter.add(it.data) }
        }
        return shareFilter
    }

    private fun filterAuthor(filter: String) {
        val news = sortedNews.filter { it.author == filter }
        showNews(news as ArrayList<NewsData>)
    }

    private fun filterTheme(filter: String) {
        val news = sortedNews.filter { it.topic == filter }
        showNews(news as ArrayList<NewsData>)
    }

    private fun filterDate(filter: String) {
        val news = sortedNews.filter { it.data == filter }
        showNews(news as ArrayList<NewsData>)
    }

//    private fun initObserver() {
//        dataModel._newsFilter.observe(this, { liveDataFilter ->
//            filter = liveDataFilter
//        })
//    }

}
