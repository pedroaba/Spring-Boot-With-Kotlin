package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course> = ArrayList()) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )

        courses = listOf(course)
    }

    fun getById(id: Long): Course {
        return courses.first {
            course -> course.id == id
        }
    }
}