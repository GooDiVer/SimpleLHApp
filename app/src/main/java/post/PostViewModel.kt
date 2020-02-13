package post

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import api.LHService
import database.pojo.Article
import kotlinx.coroutines.*
import java.lang.Exception

class PostViewModel(private val retrofit: LHService) : ViewModel() {
    private val _posts = MutableLiveData<List<Article>>()
    val posts: LiveData<List<Article>>
        get() = _posts

    private val _navigateToDetailPost = MutableLiveData<Article>()
    val navigateToDetailPost: LiveData<Article>
        get() = _navigateToDetailPost

    init {
        viewModelScope.launch {
            try {
                val response = retrofit.getPosts()
                if (response.isSuccessful) {
                    _posts.value = response.body()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onDetailPostClicked(article: Article) {
        _navigateToDetailPost.value = article
    }

    fun onDetailPostNavigated() {
        _navigateToDetailPost.value = null
    }


}