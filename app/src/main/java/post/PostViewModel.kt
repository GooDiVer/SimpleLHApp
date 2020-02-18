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
    enum class PostStatus {
        LOADING,
        DONE,
        ERROR
    }
    private val _posts = MutableLiveData<List<Article>>()
    val posts: LiveData<List<Article>>
        get() = _posts

    private val _status = MutableLiveData<PostStatus>()
    val status: LiveData<PostStatus>
        get() = _status

    private val _navigateToDetailPost = MutableLiveData<Article>()
    val navigateToDetailPost: LiveData<Article>
        get() = _navigateToDetailPost

    init {
        viewModelScope.launch {
            try {
                _status.value = PostStatus.LOADING
                val response = retrofit.getPosts()
                if (response.isSuccessful) {
                    _status.value = PostStatus.DONE
                    _posts.value = response.body()
                }
            } catch (e: Exception) {
                _status.value = PostStatus.ERROR
                _posts.value = ArrayList()
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