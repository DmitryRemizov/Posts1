package service

import data.Post

object WallService {

    private var postsArr = emptyArray<Post>()

    fun add(post: Post): Post {
        postsArr += post.copy(id = getLastPostId() + 1)
        println("Post added: ${postsArr.last()}")
        return postsArr.last()
    }

    fun update(post: Post): Boolean {
        var postUpdating = false
        for ((idx, currentPost) in postsArr.withIndex()) {
            if (post.id == currentPost.id) {
                postsArr[idx] = currentPost.copy(
                    id = post.id,
                    authorName = post.authorName,
                    content = post.content,
                    likes = post.likes,
                )
                postUpdating = true
                println("Updating post with id ${post.id}: ${postsArr[idx]}")
            }
        }
        return postUpdating
    }

    fun getLastPostId(): Int {
        return if (postsArr.isEmpty()) 0 else postsArr.last().id
    }

    fun clearWall() {
        postsArr = emptyArray<Post>()
    }
}