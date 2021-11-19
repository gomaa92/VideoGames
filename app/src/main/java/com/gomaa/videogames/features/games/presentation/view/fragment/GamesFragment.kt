package com.gomaa.videogames.features.games.presentation.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.gomaa.videogames.R
import com.gomaa.videogames.base.presentation.view.fragments.BaseFragment
import com.gomaa.videogames.base.utils.PAGE_SIZE
import com.gomaa.videogames.databinding.FragmentGamesBinding
import com.gomaa.videogames.features.games.presentation.view.adapter.GamesAdapter
import com.gomaa.videogames.features.games.presentation.viewmodel.GetGamesAction
import com.gomaa.videogames.features.games.presentation.viewmodel.GetGamesViewModel
import com.gomaa.videogames.features.games.presentation.viewmodel.GetGamesViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesFragment : BaseFragment<FragmentGamesBinding>(R.layout.fragment_games) {
    val viewModel: GetGamesViewModel by viewModels()
    private lateinit var adapter: GamesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel dispatch GetGamesAction.GetGames()
        observeViewModel()
        loadMore()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = GamesAdapter()
        dataBinding.gamesRecyclerView.adapter = adapter
    }

    private fun loadMore() {
        dataBinding.refreshLayout.setOnLoadMoreListener {
            viewModel dispatch GetGamesAction.GetGames()
        }
    }

    private fun observeViewModel() {
        hideLoading()
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                GetGamesViewState.Failure -> Toast.makeText(
                    requireContext(),
                    "failed",
                    Toast.LENGTH_SHORT
                ).show()

                is GetGamesViewState.Loading -> showLoading()
                is GetGamesViewState.Success -> {
                    adapter.addItems(it.response?.results)
                    dataBinding.refreshLayout.finishLoadMore()
                    dataBinding.refreshLayout.setEnableLoadMore(it.response?.results?.size!! >= PAGE_SIZE)

                }
                GetGamesViewState.Initial -> Toast.makeText(
                    requireContext(),
                    "Initial",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun showLoading() {
        dataBinding.gamesProgressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        dataBinding.gamesProgressBar.visibility = View.GONE
    }
}