package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.AuthorService
import br.com.alura.forum.service.CourseService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val authorService: AuthorService,
) : Mapper<NewTopicForm, Topic>() {
    override fun map(raw: NewTopicForm): Topic {
        return Topic(
            title = raw.title,
            message = raw.message,
            course = courseService.getById(raw.courseId),
            author = authorService.getById(raw.authorId)
        )
    }
}