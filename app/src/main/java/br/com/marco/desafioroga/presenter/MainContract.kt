package br.com.marco.desafioroga.presenter

import br.com.marco.desafioroga.model.datamodel.CommentsModel
import br.com.marco.desafioroga.model.datamodel.PostsModel

interface MainContract {
    interface Presenter : BasePresenter {
        fun UIAutoUpdate(data: PostsModel)
        fun UIUpdateComments(data: CommentsModel, id:String)
        fun setPoststitle(postTitle: String)
        fun networkCallPosts()
        fun networkCallComments(id: String)
    }

    interface View : BaseView<Presenter> {
       fun updateViewData(data: PostsModel)
       fun updateViewComments(data: CommentsModel, id: String)
       fun updateViewCommentsTitle(postTitle: String)
       fun disableComments()
       fun enableComments()
       fun setListenners()
       fun setAlpha(alpha: Float)
    }

    interface PostsModels{
        fun getAllPosts(presenter: MainContract.Presenter)
        fun getAllCommentsById(presenter: MainContract.Presenter, id: String)
    }

}