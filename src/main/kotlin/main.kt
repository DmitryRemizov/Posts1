import data.Likes
import data.Post
import service.WallService

fun main() {

    WallService.run {
        add(Post(authorId = 1, authorName = "test", content = "Test content", created = 20220423, likes = Likes(12)))
        add(Post(authorId = 2, authorName = "user", content = "Test content 1", created = 20220425, likes = Likes(22)))
        add(Post(authorId = 1, authorName = "test", content = "Test content 2", created = 20220425, likes = Likes(34)))

        update(Post(2, 3, "user", "Content after updating", 345623, Likes(57)))
    }
}