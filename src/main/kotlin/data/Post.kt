package data

data class Post(
    val id: Int = 0,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val created: Long,
    val likes: Int
)