package br.com.alura.forum.extention

import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.model.Topic

fun Topic.toView(): TopicView {
    return TopicView(
        this.id!!,
        this.title,
        this.message,
        this.status,
        this.createdAt
    )
}
