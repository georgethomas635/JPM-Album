package com.geo.album.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.geo.album.databinding.FragmentGalleryBinding
import com.geo.album.ui.adapters.AlbumAdapter
import com.geo.album.viewmodel.MainViewModel
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
        init()
        mainViewModel.getAlbumList()
    }

    private fun init() {
        mBinding.viewModel = mainViewModel
        mBinding.rvGiph.apply {
            layoutManager = LinearLayoutManager(context)
//            adapter = albumAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

    }
}