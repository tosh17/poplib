package ru.thstdio.study.poplib.hw4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main4.*
import ru.thstdio.study.poplib.R
import ru.thstdio.study.poplib.hw4.mvp.presenter.MainPresenter
import ru.thstdio.study.poplib.hw4.mvp.ui.MainView
import ru.thstdio.study.poplib.hw4.mvp.ui.recyclerview.GitHubItemAdapter

class Main4Activity : AppCompatActivity(), MainView {


    val presenter: MainPresenter = MainPresenter(AndroidSchedulers.mainThread())
    private lateinit var adapter: GitHubItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        presenter.attachView(this)
    }

    override fun init() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = GitHubItemAdapter(presenter.getListPresenter())
        recyclerView.adapter = adapter

    }

    override fun updateUserReposList() {
        adapter.notifyDataSetChanged()
    }
}
