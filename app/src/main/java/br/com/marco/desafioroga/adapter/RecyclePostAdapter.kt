package br.com.marco.desafioroga.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.marco.desafioroga.R
import br.com.marco.desafioroga.model.datamodel.PostsModelItem
import br.com.marco.desafioroga.presenter.MainContract
import kotlinx.android.synthetic.main.item_postagens.view.*

class RecyclePostAdapter (
    var posts: List<PostsModelItem>,
    var viewPresenter: MainContract.View,
    var presenter: MainContract.Presenter
) : RecyclerView.Adapter<RecyclePostAdapter.PostViewHolder>() {

    var idItem: String = "1"
    var postTitle: String = "1"


    inner class PostViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                val position : Int = bindingAdapterPosition
                idItem = posts[position].id.toString()
                postTitle = posts[position].title
                presenter.networkCallComments(idItem)
                presenter.setPoststitle(postTitle)
                viewPresenter.enableComments()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_postagens,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.itemView.apply {
            txt_postagens_title.text = posts[position].title
            txt_postagens_body.text = posts[position].body
            //holder.itemView.setTag(position)
        }
    }

    override fun getItemCount(): Int = posts.size



}