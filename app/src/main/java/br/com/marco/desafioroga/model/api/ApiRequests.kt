package br.com.marco.desafioroga.model.api

import br.com.marco.desafioroga.model.datamodel.CommentsModel
import br.com.marco.desafioroga.model.datamodel.PostsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequests {

    @GET("/posts")
    fun getPosts() : Call<PostsModel>

    @GET("/posts/{id}/comments")
    fun getComments(@Path("id") id: String): Call<CommentsModel>
}