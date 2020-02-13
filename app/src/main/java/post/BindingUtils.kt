package post

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.simplelifehackerapp.R
import database.pojo.Article
import kotlinx.android.synthetic.main.list_item_post.view.*

@BindingAdapter("postImage")
fun ImageView.setPostImage(article: Article) {
    Glide.with(this.context)
        .load(article.catCover.sizes.mobile)
        .placeholder(R.drawable.ic_broken_image_black_24dp)
        .centerCrop()
        .into(this)
}

@BindingAdapter("postArticle")
fun TextView.setPostArticle(article: Article) {
    text = article.title.rendered
}