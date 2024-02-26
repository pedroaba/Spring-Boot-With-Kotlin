package br.com.alura.forum.controller

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {
    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicView {
        return service.getById(id)
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody @Valid topic: NewTopicForm) {
        service.register(topic)
    }

    @PutMapping
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@RequestBody @Valid topic: UpdateTopicForm) {
        service.update(topic)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}