package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = mutableListOf(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {
    fun list(): List<TopicView> {
        return topics.map { topic -> topicViewMapper.map(topic) }
    }

    fun getById(id: Long): TopicView {
        val topic = topics.first { topic ->
            topic.id == id
        }

        return topicViewMapper.map(topic)
    }

    fun register(topicDto: NewTopicForm) {
        val topic = topicFormMapper.map(topicDto)
        topic.id = topics.size.toLong() + 1

        topics = topics.plus(topic)
    }

    fun update(topic: UpdateTopicForm) {
        val topicOnDb = topics.first {
                t -> t.id == topic.id
        }

        val updatedTopic = Topic(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            course = topicOnDb.course,
            author = topicOnDb.author,
            createdAt = topicOnDb.createdAt,
            status = topicOnDb.status
        )

        topics = topics.filter { t -> t.id != topic.id }.plus(updatedTopic)
    }

    fun delete(id: Long) {
        topics = topics.filter {
            topic -> topic.id != id
        }
    }
}