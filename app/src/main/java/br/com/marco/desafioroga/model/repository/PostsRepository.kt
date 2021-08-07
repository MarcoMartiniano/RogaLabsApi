package br.com.marco.desafioroga.model.repository

import android.util.Log
import br.com.marco.desafioroga.model.api.ApiJob
import br.com.marco.desafioroga.model.api.ApiRequests
import br.com.marco.desafioroga.model.datamodel.CommentsModel
import br.com.marco.desafioroga.model.datamodel.PostsModel
import br.com.marco.desafioroga.presenter.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostsRepository : MainContract.PostsModels{

    private var apiClient: ApiRequests? = null

    init {
        apiClient = ApiJob.client.create(ApiRequests::class.java)
    }

    override fun getAllPosts(presenter: MainContract.Presenter) {
        val call = apiClient?.getPosts()
        call?.enqueue(object : Callback<PostsModel>{
            override fun onResponse(call: Call<PostsModel>, response: Response<PostsModel>) {
                if(response.isSuccessful){
                    val results = response.body()
                    Log.e("Resultssss",results.toString())
                    //atualizar a UI
                    presenter.UIAutoUpdate(results!!)
                }
            }
            override fun onFailure(call: Call<PostsModel>, t: Throwable) {
                Log.e("Error",t.toString())

            }
        })
    }

    override fun getAllCommentsById(presenter: MainContract.Presenter, id: String) {
        val call = apiClient?.getComments(id)
        call?.enqueue(object : Callback<CommentsModel>{
            override fun onResponse(call: Call<CommentsModel>, response: Response<CommentsModel>) {
                if(response.isSuccessful){
                    val results = response.body()
                    Log.e("ResultadoCommentsbyid",results.toString())
                    //atualizar a UI das Comments
                    presenter.UIUpdateComments(results!!,id)
                }
            }

            override fun onFailure(call: Call<CommentsModel>, t: Throwable) {
                Log.e("Error",t.toString())
            }

        })


    }




}