package com.gomaa.videogames.features.geners.presentation.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.gomaa.videogames.R
import com.gomaa.videogames.base.presentation.view.fragments.BaseFragment
import com.gomaa.videogames.databinding.FragmentGenresBinding
import com.gomaa.videogames.features.geners.domain.data.entities.GenresObject
import com.gomaa.videogames.features.geners.presentation.view.adapter.GenresAdapter
import com.gomaa.videogames.features.geners.presentation.view.listener.OnGenresClickListener
import com.gomaa.videogames.features.geners.presentation.viewmodel.GetGenresActions
import com.gomaa.videogames.features.geners.presentation.viewmodel.GetGenresViewModel
import com.gomaa.videogames.features.geners.presentation.viewmodel.GetGenresViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenresFragment : BaseFragment<FragmentGenresBinding>(R.layout.fragment_genres),
    OnGenresClickListener {
    val viewModel: GetGenresViewModel by viewModels()
    private lateinit var adapter: GenresAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel dispatch GetGenresActions.GetGeneresAction
        observeViewModel()
        initRecyclerView()
        finishSelectGenres()
    }

    private fun initRecyclerView() {
        adapter = GenresAdapter(this)
        dataBinding.genresRecyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        hideLoading()
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                GetGenresViewState.Failure -> Toast.makeText(
                    requireContext(),
                    "failed",
                    Toast.LENGTH_SHORT
                ).show()
                GetGenresViewState.InitialState -> Toast.makeText(
                    requireContext(),
                    "initial",
                    Toast.LENGTH_SHORT
                ).show()
                is GetGenresViewState.Loading -> showLoading()
                is GetGenresViewState.Success -> {
                    hideLoading()
                    adapter.setItems(it.response?.results)
                }
                GetGenresViewState.FinishSaveIds -> Toast.makeText(
                    requireContext(),
                    "navigate",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun showLoading() {
        dataBinding.genresProgressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        dataBinding.genresProgressBar.visibility = View.GONE
    }

    override fun onItemClicked(item: GenresObject, position: Int) {
        item.isSelected = !item.isSelected
        adapter.notifyItemChanged(position)
        viewModel dispatch GetGenresActions.HandleGenresId(item.id)
    }

    private fun finishSelectGenres() {
        dataBinding.doneButton.setOnClickListener {
            viewModel dispatch GetGenresActions.FinishSelectGenres
        }
    }
}