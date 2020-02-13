package post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.simplelifehackerapp.R
import kotlinx.android.synthetic.main.fragment_post.*
import org.koin.android.viewmodel.ext.android.viewModel

class PostFragment : Fragment() {
    private lateinit var adapter: PostAdapter
    private val viewModel: PostViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        adapter = PostAdapter(DetailPostListener { article ->
            viewModel.onDetailPostClicked(article)
        })

        (activity as AppCompatActivity).supportActionBar?.hide()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_post.adapter = adapter

        viewModel.posts.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.navigateToDetailPost.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    PostFragmentDirections.actionPostFragmentToPostDetailFragment(
                        it.title.rendered,
                        it.content.rendered
                    )
                )
                viewModel.onDetailPostNavigated()
            }
        })
    }


}