package service

import data.Likes
import data.Post
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clear() {
        WallService.clearWall()
    }

    @Test
    fun add() {
        //1. Arrange — подготовка данных (задание переменных).
        val authorId = 1
        val authorName = "test"
        val content = "Test content"
        val created: Long = 20220423
        val post =
            Post(authorId = authorId, authorName = authorName, content = content, created = created, likes = Likes(1))
        //2. Act — выполнение целевого действия (вызов функции).

        val createdPost = WallService.add(post)
        //3. Assert — сравнение ожидаемого результата с фактическим.
        assertNotEquals(0, createdPost.id)
    }

    @Test
    fun update_existingPost() {
        //1. Arrange — подготовка данных (задание переменных).
        val authorId = 1
        val authorName = "test"
        val content = "Test content"
        val created: Long = 20220423
        val post =
            Post(authorId = authorId, authorName = authorName, content = content, created = created, likes = Likes(2))

        val updatingId = 1
        val updatingAuthorId = 1
        val updatingAuthorName = "test"
        val updatingContent = "Content after updating"
        val updatingCreated: Long = 19970101
        val updatingPost =
            Post(
                id = updatingId,
                authorId = updatingAuthorId,
                authorName = updatingAuthorName,
                content = updatingContent,
                created = updatingCreated,
                likes = Likes(1)
            )
        //2. Act — выполнение целевого действия (вызов функции).
        WallService.add(post)
        val result = WallService.update(updatingPost)
        //3. Assert — сравнение ожидаемого результата с фактическим.
        assertTrue(result)
    }
    @Test
    fun update_notExistingPost() {
        //1. Arrange — подготовка данных (задание переменных).
        val authorId = 1
        val authorName = "test"
        val content = "Test content"
        val created: Long = 20220423
        val post =
            Post(authorId = authorId, authorName = authorName, content = content, created = created, likes = Likes(4))
        val updatingId = 17 //несуществующий пост
        val updatingAuthorId = 1
        val updatingAuthorName = "test"
        val updatingContent = "Content after updating"
        val updatingCreated: Long = 19970101
        val updatingPost =
            Post(
                id = updatingId,
                authorId = updatingAuthorId,
                authorName = updatingAuthorName,
                content = updatingContent,
                created = updatingCreated,
                likes = Likes(3)
            )
        //2. Act — выполнение целевого действия (вызов функции).
        WallService.add(post)
        val result = WallService.update(updatingPost)
        //3. Assert — сравнение ожидаемого результата с фактическим.
        assertFalse(result)
    }
    @Test
    fun getLastPostId_emptyWall() {
        //1. Arrange — подготовка данных (задание переменных).
        // Ничего не задаем
        //2. Act — выполнение целевого действия (вызов функции).
        val result = WallService.getLastPostId()
        //3. Assert — сравнение ожидаемого результата с фактическим.
        assertEquals(0, result)
    }
    @Test
    fun getLastPostId_notEmptyWall() {
        //1. Arrange — подготовка данных (задание переменных).
        val authorId = 1
        val authorName = "test"
        val content = "Test content"
        val created: Long = 20220423
        val post =
            Post(authorId = authorId, authorName = authorName, content = content, created = created, likes = Likes(3))
        //2. Act — выполнение целевого действия (вызов функции).
        WallService.add(post)
        val result = WallService.getLastPostId()
        //3. Assert — сравнение ожидаемого результата с фактическим.
        assertNotEquals(0, result)
    }
}