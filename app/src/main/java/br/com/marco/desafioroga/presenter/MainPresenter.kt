package br.com.marco.desafioroga.presenter

import br.com.marco.desafioroga.model.datamodel.CommentsModel
import br.com.marco.desafioroga.model.datamodel.PostsModel
import br.com.marco.desafioroga.model.repository.PostsRepository

class MainPresenter (view: MainContract.View): MainContract.Presenter{

    private var view: MainContract.View? = view
    private var models: MainContract.PostsModels = PostsRepository()



    override fun UIAutoUpdate(data: PostsModel) {
        view?.updateViewData(data)
    }

    override fun UIUpdateComments(data: CommentsModel, id: String) {
        view?.updateViewComments(data,id)
    }

    override fun setPoststitle(postTitle: String) {
        view?.updateViewCommentsTitle(postTitle)
    }

    override fun networkCall() {
        models?.getAllPosts(this)
    }

    override fun networkCallComments(id:String) {
        models?.getAllCommentsById(this,id)
    }



    override fun onDestroy() {
        this.view = null
    }


}