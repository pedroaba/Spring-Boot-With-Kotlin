package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.extention.toView
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView>() {
    override fun map(raw: Topic): TopicView {
        return raw.toView()
    }
}