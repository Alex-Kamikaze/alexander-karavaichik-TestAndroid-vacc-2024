package com.alexkarav.testandroidvacc24.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.alexkarav.testandroidvacc24.databinding.FragmentProductDetailsBinding
import com.alexkarav.testandroidvacc24.domain.models.ProductListItemModel
import com.alexkarav.testandroidvacc24.presentation.viewmodels.ProductDetailsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ProductDetailsFragment : Fragment() {
    private var binding: FragmentProductDetailsBinding? = null
    private val args: ProductDetailsFragmentArgs by navArgs()
    private lateinit var productDetails: ProductListItemModel
    private val viewModel: ProductDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(inflater)
        viewModel.loadProductDetails(args.productId)
        lifecycleScope.launch {
            viewModel.productDetails.collectLatest {
                productDetails = it
            }
        }


        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProductDetailsFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}