package com.sorianog.memelist.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorianog.memelist.R
import com.sorianog.memelist.network.model.Meme
import com.sorianog.memelist.viewmodel.HomeViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    val compositeDisposable = CompositeDisposable()
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.init()

        getMemes()
    }

    private fun getMemes() {
        compositeDisposable.add(viewModel.getMemes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                Log.i("MEMES", response.data.toString())
                Log.i("MEMES", response.data.memes.get(0).name)
                Log.i("MEMES", response.data.memes.get(0).imgUrl.toString())

                setMemeList(response.data.memes)

            }, Throwable::printStackTrace)
        );
    }

    private fun setMemeList(memes: List<Meme>) {
        memeList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MemeListAdapter(memes)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
