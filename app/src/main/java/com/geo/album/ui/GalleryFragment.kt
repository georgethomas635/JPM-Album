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
        handleErrorState()
        checkInternetConnection()
        getAlbumList()
        init()
        setShareOption()
    }

    /**
     * Check Internet connection is available
     */
    private fun checkInternetConnection() {
        if (!AppUtils.isOnline(requireContext())) {
            showErrorMessage(resources.getString(R.string.message_connection_lost))
        }
    }

    /**
     * Handle API call error cases and show the error message in Screen.
     */
    private fun handleErrorState() {
        mainViewModel.checkErrorState().observe(viewLifecycleOwner) {
            showErrorMessage(it)
        }
    }

    /**
     * Fetch album list from server
     */
    private fun getAlbumList() {
        mainViewModel.getAlbumList().observe(viewLifecycleOwner) {
            albumAdapter.updateItem(it)
        }
    }

    /**
     * Initialising basic view
     */
    private fun init() {
        mBinding.rvAlbums.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = albumAdapter
        }

    }

    /**
     * handling share option of recyclerview item
     */
    private fun setShareOption() {
        albumAdapter.onItemClick = {
            AppUtils.shareWith(it, requireContext())
        }
    }

    /**
     * Show error messages as snackbar
     */
    private fun showErrorMessage(errorMessage: String) {
        Snackbar.make(
            mBinding.rvAlbums, errorMessage,
            Snackbar.LENGTH_LONG
        ).show()
    }
}