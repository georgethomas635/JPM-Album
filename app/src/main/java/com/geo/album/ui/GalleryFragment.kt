package com.geo.album.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.geo.album.R
import com.geo.album.databinding.FragmentGalleryBinding
import com.geo.album.ui.adapters.AlbumAdapter
import com.geo.album.utils.AppUtils
import com.geo.album.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by George Thomas on 29/9/21
 */
@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private lateinit var mBinding: FragmentGalleryBinding
    private val mainViewModel: MainViewModel by viewModels()

    private val albumAdapter = AlbumAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentGalleryBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getAlbumList()
        init()
        setShareOption()
        mainViewModel.getAlbumList()
    }

    private fun getAlbumList() {
        if (AppUtils.isOnline(requireContext())) {
            mainViewModel.getAlbumList().observe(viewLifecycleOwner) {
                albumAdapter.updateItem(it)
            }
        }else{
            noNetworkError()
        }
    }

    private fun init() {
        mBinding.rvGiph.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = albumAdapter
        }

    }

    private fun setShareOption() {
        albumAdapter.onItemClick={
            AppUtils.shareWith(it,requireContext())
        }
    }

    private fun noNetworkError() {
        requireActivity().currentFocus?.let { Snackbar.make(it,resources.getString(R.string.message_connection_lost), Snackbar.LENGTH_LONG).show() }
    }
}