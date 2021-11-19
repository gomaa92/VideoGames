package com.gomaa.videogames.features.games.presentation.view.adapter

import android.view.View
import com.gomaa.videogames.R
import com.gomaa.videogames.base.utils.Utils
import com.gomaa.videogames.base.presentation.view.adapter.BaseRecyclerViewAdapter
import com.gomaa.videogames.databinding.GenresLayoutItemBinding
import com.gomaa.videogames.features.games.data.model.entities.GameEntity

class GamesAdapter() :
    BaseRecyclerViewAdapter<GameEntity, GenresLayoutItemBinding, GamesAdapter.ListGamesViewHolder>(
    ) {
    override fun getLayout(type: Int): Int {
        return R.layout.genres_layout_item
    }

    override fun getViewHolder(view: View, type: Int): ListGamesViewHolder {
        return ListGamesViewHolder(view)
    }

    inner class ListGamesViewHolder(itemView: View) :
        BaseRecyclerViewAdapter.BaseRecyclerViewHolder<GameEntity, GenresLayoutItemBinding>(
            itemView
        ) {

        override fun onBind(item: GameEntity) {
            dataBinding?.favIcon?.visibility = View.GONE
            dataBinding?.genresTitle?.text = item.name
            Utils.loadImage(itemView.context, dataBinding?.genresImageView, item.backgroundImage)


        }
    }
}