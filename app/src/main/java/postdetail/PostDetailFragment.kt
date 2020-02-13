package postdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.simplelifehackerapp.R
import kotlinx.android.synthetic.main.fragment_post_detail.*

class PostDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post_detail, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = PostDetailFragmentArgs.fromBundle(arguments!!)
        val wvContent = "<h2>${args.postTitle}</h2> ${args.postContent}"
        val webView: WebView = post_detail_webview

        webView.loadDataWithBaseURL(null, wvContent, "text/html", "utf-8", null)
    }

}