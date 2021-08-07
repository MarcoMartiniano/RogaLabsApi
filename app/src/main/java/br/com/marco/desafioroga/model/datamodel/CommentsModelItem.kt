package br.com.marco.desafioroga.model.datamodel

data class CommentsModelItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)