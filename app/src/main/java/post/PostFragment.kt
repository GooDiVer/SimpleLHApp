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
import com.example.simplelifehackerapp.databinding.FragmentPostBinding
import com.google.android.material.snackbar.Snackbar
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
        val binding = FragmentPostBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.hide()
        adapter = PostAdapter(DetailPostListener { article ->
            viewModel.onDetailPostClicked(article)
        })
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_post.adapter = adapter

        viewModel.posts.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.showSnackbarEvent.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.check_internet_connetion),
                    Snackbar.LENGTH_LONG // How long to display the message.
                ).show()
                viewModel.doneShowShackbar()
            }
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