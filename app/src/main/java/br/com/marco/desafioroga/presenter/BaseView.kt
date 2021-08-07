package br.com.marco.desafioroga.presenter

interface BaseView<T> {
    fun setPresenter(presenter : T)
}