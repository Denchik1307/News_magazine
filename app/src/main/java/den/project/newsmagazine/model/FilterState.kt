package den.project.newsmagazine.model

data class FiltersState(
    val comparators: List<(News) -> Boolean>,
)
