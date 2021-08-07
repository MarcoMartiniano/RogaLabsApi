package br.com.marco.desafioroga.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.marco.desafioroga.R
import br.com.marco.desafioroga.model.datamodel.CommentsModelItem
import kotlinx.android.synthetic.main.item_comentarios.view.*


class RecycleCommentsAdapter (
    private var comments: List<CommentsModelItem>
        ): RecyclerView.Adapter<RecycleCommentsAdapter.CommentsViewHolder>(){

    inner class CommentsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comentarios,parent,false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.itemView.apply {
            txt_comentarios_name.text = comments[position].name
            txt_comentarios_email.text = comments[position].email
            txt_comentarios_body.text = comments[position].body
        }



    }

    override fun getItemCount(): Int  = comments.size
}