package koin

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import post.PostViewModel

object ViewModelModule {
    val module = module {
        viewModel<PostViewModel> { PostViewModel(retrofit = get()) }
    }
}