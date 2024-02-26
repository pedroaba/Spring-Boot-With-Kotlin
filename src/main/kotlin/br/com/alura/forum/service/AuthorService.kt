package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.User
import br.com.alura.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(
    private val repository: UserRepository
) : BaseService() {

    fun getById(id: Long): User {
        return repository.findById(id).orElseThrow{NotFoundException(notFoundExceptionMessage)}
    }
}