package io.wisoft.seminar

import io.wisoft.seminar.tables.Users.Companion.USERS
import io.wisoft.seminar.tables.pojos.Users
import org.assertj.core.api.Assertions.assertThat
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Service

@Service
class SimpleUserService(private val dslContext: DSLContext) {
    fun count(): Int {
        return executeQuery {
            dslContext
                .select(*USERS.fields())
                .from(USERS)
                .fetchInto(Users::class.java).size
        }
    }

    fun insert(username: String): Int {
        return executeQuery {
            dslContext
                .insertInto(USERS)
                .set(USERS.USERNAME, username)
                .execute()
        }
    }

    fun removeAll() {
        return executeQuery {
            dslContext.transaction { conf: Configuration ->
                val query: DSLContext = DSL.using(conf)
                query
                    .deleteFrom(USERS)
                    .execute()

                query
                    .alterSequence("users_id_seq")
                    .restartWith(1)
                    .execute()
            }
        }
    }

    fun <R> executeQuery(f: (DSLContext) -> R): R {
        val runCatching: Result<R> = runCatching {
            f(dslContext)
        }

        runCatching.onFailure {
            it.printStackTrace()
        }
        return runCatching.getOrThrow()
    }
}

@SpringBootTest
class SimpleTest {

    @Autowired
    private lateinit var userService: SimpleUserService

    @Test
    @DisplayName("컨테이너 로드")
    fun loadContainer() {
    }

    @Test
    @DisplayName("유저 수 카운트")
    fun `유저 수 카운트`() {
        val count: Int = this.userService.count()

        assertThat(count).isEqualTo(0)
    }

    @Test
    @DisplayName("사용자 추가")
    fun `사용자 추가`() {
        assertThat(this.userService.insert("daewon")).isEqualTo(1)
    }

    @Test
    @DisplayName("전체 사용자 삭제")
    fun `전체 사용자 삭제`() {
        this.userService.removeAll()
        assertThat(this.userService.count()).isEqualTo(0)
    }
}
