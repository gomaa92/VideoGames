package com.gomaa.videogames.features.geners.presentation.view.adapter

import android.view.View
import com.gomaa.videogames.R
import com.gomaa.videogames.base.Utils
import com.gomaa.videogames.base.presentation.view.adapter.BaseRecyclerViewAdapter
import com.gomaa.videogames.databinding.GenresLayoutItemBinding
import com.gomaa.videogames.features.geners.domain.data.entities.GenresObject
import com.gomaa.videogames.features.geners.presentation.view.listener.OnGenresClickListener

class GenresAdapter(private val mListener: OnGenresClickListener) :
    BaseRecyclerViewAdapter<GenresObject, GenresLayoutItemBinding, GenresAdapter.ListAvailableNameViewHolder>(
    ) {
    override fun getLayout(type: Int): Int {
        return R.layout.genres_layout_item
    }

    override fun getViewHolder(view: View, type: Int): ListAvailableNameViewHolder {
        return ListAvailableNameViewHolder(view)
    }

    inner class ListAvailableNameViewHolder(itemView: View) :
        BaseRecyclerViewAdapter.BaseRecyclerViewHolder<GenresObject, GenresLayoutItemBinding>(
            itemView
        ) {

        override fun onBind(item: GenresObject) {
            dataBinding?.genresTitle?.text = item.name
            Utils.loadImage(itemView.context, dataBinding?.genresImageView, item.imageBackground)
            dataBinding?.favIcon?.setOnClickListener {
                mListener.onItemClicked(item,adapterPosition)
            }
            if (item.isSelected)
                dataBinding?.favIcon?.setImageResource(R.drawable.ic_star_colored)
            else
                dataBinding?.favIcon?.setImageResource(R.drawable.ic_star)

        }


    }
}