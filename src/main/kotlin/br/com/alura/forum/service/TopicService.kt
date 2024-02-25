package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class TopicService(private var topics: List<Topic>) {
    init {
        val topic1 = Topic(
            id = 1,
            title = "Dúvidas de Kotlin 1",
            message = "Variáveis no Kotlin 1",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic2 = Topic(
            id = 2,
            title = "Dúvidas de Kotlin 2",
            message = "Variáveis no Kotlin 2",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic3 = Topic(
            id = 2,
            title = "Dúvidas de Kotlin 3",
            message = "Variáveis no Kotlin 3",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        this.topics = listOf(topic1, topic2, topic3)
    }

    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.first { topic ->
            topic.id == id
        }
    }
}