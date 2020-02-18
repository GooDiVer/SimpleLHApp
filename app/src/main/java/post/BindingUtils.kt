package post

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.simplelifehackerapp.R
import database.pojo.Article
import kotlinx.android.synthetic.main.list_item_post.view.*

@BindingAdapter("postStatus")
fun postStatus(imageView: ImageView, status: PostViewModel.PostStatus?) {
    when (status) {
        PostViewModel.PostStatus.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }
        PostViewModel.PostStatus.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_report_problem_black_24dp)
        }
        PostViewModel.PostStatus.DONE -> {
            imageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("postImage")
fun setPostImage(imageView: ImageView, article: Article) {
    Glide.with(imageView.context)
        .load(article.catCover.sizes.mobile)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image_black_24dp)
        )
        .centerCrop()
        .into(imageView)
}

@BindingAdapter("postArticle")
fun TextView.setPostArticle(article: Article) {
    text = article.title.rendered
}