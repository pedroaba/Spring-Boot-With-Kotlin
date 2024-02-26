package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicForm(
    @field:NotNull
    @field:Size(min = 5, max = 100)
    val id: Long,

    @field:NotEmpty
    val title: String,

    @field:NotEmpty
    val message: String
)
