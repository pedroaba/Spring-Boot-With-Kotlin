package br.com.alura.forum.service

import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class AuthorService(var users: List<User> = ArrayList()) {
    init {
        val user = User(
            id = 1,
            name = "Ana da Silva",
            email = "ana@email.com"
        )

        users = listOf(user)
    }

    fun getById(id: Long): User {
        return users.first {
                user -> user.id == id
        }
    }
}