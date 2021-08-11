package br.com.marco.desafioroga.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.marco.desafioroga.R
import br.com.marco.desafioroga.adapter.RecycleCommentsAdapter
import br.com.marco.desafioroga.adapter.RecyclePostAdapter
import br.com.marco.desafioroga.model.datamodel.CommentsModel
import br.com.marco.desafioroga.model.datamodel.CommentsModelItem
import br.com.marco.desafioroga.model.datamodel.PostsModel
import br.com.marco.desafioroga.model.datamodel.PostsModelItem
import br.com.marco.desafioroga.presenter.MainContract
import br.com.marco.desafioroga.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_postagens.*

class PostsActivity : AppCompatActivity() , MainContract.View{

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postagens)

        setPresenter(MainPresenter(this))
        setListenners()
        disableComments()
        presenter.networkCallPosts()

    }


    override fun updateViewData(data: PostsModel) {
        displayPosts(data)
    }

    override fun updateViewComments(data: CommentsModel, id: String) {
        //presenter.networkCallComments(id)
        displayComments(data)
    }

    override fun updateViewCommentsTitle(postTitle: String) {
        txt_titulopostagem.text = postTitle

    }


    private fun displayPosts(data: List<PostsModelItem>) {
        val adapterPosts = RecyclePostAdapter(data,this,presenter)
        rv_postagens.adapter = adapterPosts
        rv_postagens.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun displayComments(data: List<CommentsModelItem>) {
        val adapterComments = RecycleCommentsAdapter(data)
        rv_comentarios.adapter = adapterComments
        rv_comentarios.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun disableComments() {
        framelayout_comentarios.visibility = View.GONE
        setAlpha(1.0f)
    }

    override fun enableComments() {
        framelayout_comentarios.visibility = View.VISIBLE
        setAlpha(0.5f)
    }

    override fun setListenners() {
        floating_action_button.setOnClickListener { disableComments()
        }
    }

    override fun setAlpha(alpha: Float) {
        rv_postagens.alpha = alpha
        layout_header.alpha = alpha
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

}