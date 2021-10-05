package com.geo.album.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geo.album.databinding.ItemAlbumBinding
import com.geo.album.domain.models.AlbumResult

/**
 * Created by George Thomas on 29/9/21
 */
class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private val albumList = ArrayList<AlbumResult>()
    var onItemClick: ((String) -> Unit)? = null


    class ViewHolder(val view: ItemAlbumBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(albumResult: AlbumResult, onItemClick: ((String) -> Unit)?) {
            view.viewModel = albumResult
            view.imgShare.setOnClickListener {
                onItemClick?.invoke(albumResult.title)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albumList[position], onItemClick)
    }

    /**
     * return the number of items in album list
     */
    override fun getItemCount(): Int {
        return albumList.size
    }

    /**
     * Update the recyclerview with latest album list
     */
    fun updateItem(albums: ArrayList<AlbumResult>) {
        albumList.clear()
        albumList.addAll(albums)
        notifyDataSetChanged()
    }
}