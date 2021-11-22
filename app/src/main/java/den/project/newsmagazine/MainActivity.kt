package den.project.newsmagazine

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import den.project.newsmagazine.data.NewsRepository
import den.project.newsmagazine.data.impl.NewsRepositoryImpl
import den.project.newsmagazine.databinding.ActivityMainBinding
import den.project.newsmagazine.model.News
import den.project.newsmagazine.presentation.NewsFilterAdapter
import den.project.newsmagazine.presentation.NewsFragmentAdapter
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val feedViewModel: NewsRepository = NewsRepositoryImpl()
    private var listNews = NewsFragmentAdapter.newInstance()
    private var filterNews = NewsFilterAdapter.newInstance()
    private val news = feedViewModel.getNews()
    private var filter: String = ResourceTheme.ALL.source

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragmentNews(news)
    }


    fun clic_sort(item: android.view.MenuItem) {
        showFragmentFilter(news)

        Log.d("MyLog", "qwer " + news.filter {
            it.topic == "Игры"
        }.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showFragmentNews(news: ArrayList<News>) {
        binding.apply {
            fragmentNewsHolder.layoutManager = LinearLayoutManager(this@MainActivity)
            fragmentNewsHolder.adapter = listNews
            listNews.showNews(news)
        }
    }

    private fun showFragmentFilter(news: ArrayList<News>) {
        binding.apply {
            fragmentNewsHolder.layoutManager = LinearLayoutManager(this@MainActivity)
            fragmentNewsHolder.adapter = filterNews
            filterNews.showNews(news)
        }
    }


}
