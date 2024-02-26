package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) : BaseService() {

    fun list(): List<TopicView> {
        return repository.findAll().map { topic -> topicViewMapper.map(topic) }
    }

    fun getById(id: Long): TopicView {
        val topic = repository.findById(id).orElseThrow { NotFoundException(notFoundExceptionMessage) }

        return topicViewMapper.map(topic)
    }

    fun register(topicDto: NewTopicForm) {
        val topic = topicFormMapper.map(topicDto)
        repository.save(topic)
    }

    fun update(topic: UpdateTopicForm) {
        val topicOnDb = repository.findById(topic.id).orElseThrow { NotFoundException(notFoundExceptionMessage) }
        topicOnDb.let {
            it.title = topic.title
            it.message = topic.message
        }
    }

    fun delete(id: Long) {
        repository.findById(id).orElseThrow { NotFoundException(notFoundExceptionMessage) }
        repository.deleteById(id)
    }
}