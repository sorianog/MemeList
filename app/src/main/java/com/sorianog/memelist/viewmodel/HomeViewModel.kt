package com.sorianog.memelist.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorianog.memelist.network.ApiClient
import com.sorianog.memelist.network.MemeAPI
import com.sorianog.memelist.network.model.ApiResponse
import com.sorianog.memelist.network.model.Meme
import com.sorianog.memelist.view.MemeListAdapter
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_home.*

class HomeViewModel : ViewModel() {

    lateinit var memeAPI: MemeAPI

    fun init() {
        memeAPI = ApiClient.client.create(MemeAPI::class.java)
    }

    fun getMemes() : Single<ApiResponse> {
        return memeAPI.getMemes()
    }
}