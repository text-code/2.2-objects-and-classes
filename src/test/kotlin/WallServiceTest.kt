import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @After
    fun clearDate() {
        WallService.removeAll()
    }

    @Test
    fun id_must_not_be_0() {
        // arrange
        val post = Post(
            0,
            1,
            1,
            1,
            1,
            "",
            1,
            1,
            false,
            1,
            "",
            1,
            1,
            1,
            "",
            1,
            false,
            false,
            false,
            1,
            false,
            false,
            "",
            1
        )
        val expectedPostId = 0
        // act
        val actualPostId = WallService.add(post)
        // assert
//        assertEquals(expectedPostId, actualPostId.id)
        assertNotEquals(expectedPostId, actualPostId.id)
    }

    @Test
    fun updating_an_existing_post() {
        // arrange
        WallService.add(Post(
            0,
            1,
            1,
            1,
            1,
            "",
            1,
            1,
            false,
            1,
            "",
            1,
            1,
            1,
            "",
            1,
            false,
            false,
            false,
            1,
            false,
            false,
            "",
            1
        ))
        val postUpdate = Post(
            1,
            1,
            1,
            1,
            1,
            "",
            1,
            1,
            false,
            1,
            "test",
            1,
            1,
            1,
            "",
            1,
            false,
            false,
            false,
            1,
            false,
            false,
            "",
            1
        )
        val expectedUpdatePost = true
        // act
        val actualUpdatePost = WallService.update(postUpdate)
        // assert
        assertEquals(expectedUpdatePost, actualUpdatePost)
    }

    @Test
    fun update_a_nonexistent_post() {
        // arrange
        val postUpdate = Post(
            2,
            1,
            1,
            1,
            1,
            "",
            1,
            1,
            false,
            1,
            "test",
            1,
            1,
            1,
            "",
            1,
            false,
            false,
            false,
            1,
            false,
            false,
            "",
            1
        )
        val expectedUpdatePost = false
        // act
        val actualUpdatePost = WallService.update(postUpdate)
        // assert
        assertEquals(expectedUpdatePost, actualUpdatePost)
    }
}