package br.com.alura.forum.mapper

abstract class Mapper<Raw, U> {
    abstract fun map(raw: Raw): U
}