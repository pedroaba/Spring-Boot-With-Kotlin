package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
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
}