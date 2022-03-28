data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwner_id: Int,
    val replyPost_id: Int,
    val friendsOnly: Boolean,
    val comments: Int, //object
    val copyright: String, //object
    val likes: Int, //object
    val reposts: Int, //object
    val views: Int, //object
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Int,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: String, //object
    val postponedId: Int,
)

object WallService {
    private var posts = emptyArray<Post>()
    private var listId: Int = 0

    fun add(post: Post): Post {
        listId++
        post.id = listId
        posts += post
        return posts.last()
    }

    fun update(postUpdate: Post): Boolean {
        for (post in posts) {
            if (postUpdate.id == post.id) {
                posts[post.id - 1] = post.copy(
//                    id = postUpdate.id,
                    ownerId = postUpdate.ownerId,
                    fromId = postUpdate.fromId,
                    createdBy = postUpdate.createdBy,
//                    date = postUpdate.date,
                    text = postUpdate.text,
                    replyOwner_id = postUpdate.replyOwner_id,
                    replyPost_id = postUpdate.replyPost_id,
                    friendsOnly = postUpdate.friendsOnly,
                    comments = postUpdate.comments,
                    copyright = postUpdate.copyright,
                    likes = postUpdate.likes,
                    reposts = postUpdate.reposts,
                    views = postUpdate.views,
                    postType = postUpdate.postType,
                    signerId = postUpdate.signerId,
                    canPin = postUpdate.canPin,
                    canDelete = postUpdate.canDelete,
                    canEdit = postUpdate.canEdit,
                    isPinned = postUpdate.isPinned,
                    markedAsAds = postUpdate.markedAsAds,
                    isFavorite = postUpdate.isFavorite,
                    donut = postUpdate.donut,
                    postponedId = postUpdate.postponedId,
                )
                return true
            } else if (postUpdate.id >= posts.size) {
                return false
            }
        }
        return false
    }

    fun removeAll() {
        listId = 0
    }
}