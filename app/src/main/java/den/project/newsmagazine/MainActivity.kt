package den.project.newsmagazine

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import den.project.newsmagazine.data.NewsRepository
import den.project.newsmagazine.data.impl.NewsRepositoryImpl
import den.project.newsmagazine.databinding.ActivityMainBinding
import den.project.newsmagazine.domain.GetNewsUseCase
import den.project.newsmagazine.domain.impl.GetNewsUseCaseImpl
import den.project.newsmagazine.model.FiltersState
import den.project.newsmagazine.model.News
import den.project.newsmagazine.presentation.FeedViewModel
import den.project.newsmagazine.presentation.fragments.NewsFragment
import den.project.newsmagazine.presentation.impl.FeedViewModelImpl
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val repository: NewsRepository = NewsRepositoryImpl()
    private val useCase: GetNewsUseCase = GetNewsUseCaseImpl(repository)
    private val feedViewModel: FeedViewModel = FeedViewModelImpl(useCase)
    private var listNews = NewsFragment.newInstance()
    private val news = repository.getNews()

    private var filter: String = ResourceTheme.ALL.theme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showSortedNews(news)
        feedViewModel
            .getFilteredNews(
                FiltersState(
                    comparators = listOf(
                        byIdComparator,
                        byArticleComparator
                    )
                )
            ) //Добавляешь компараторы по мере выбора условия во фрагменте
            .forEach { println(it) }
    }


    fun clic_sort(item: android.view.MenuItem) {


        Log.d("MyLog", "qwer " + news.filter {
            it.topic == "Игры"
//            it.author == "Игры"
        }.toString())

    }

    val byIdComparator = { data: News ->
        data.id.toInt() < 3
    }

    val byArticleComparator = { data: News ->
        data.label.contains("2")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showSortedNews(news: ArrayList<News>) {
        binding.apply {
            fragmentNewsHolder.layoutManager = LinearLayoutManager(this@MainActivity)
            fragmentNewsHolder.adapter = listNews
            listNews.showNews(news)
        }
    }


}
