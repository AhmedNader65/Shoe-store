package com.udacity.shoestore.ui.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.ui.login.LoginViewModel

class ListingFragment : Fragment() {

    private lateinit var viewModel: ListingViewModel
    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ListingViewModel::class.java]
        _binding = FragmentListingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = viewModel
        binding.lifecycleOwner = this
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}