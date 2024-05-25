package com.alexkarav.testandroidvacc24.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.alexkarav.testandroidvacc24.databinding.FragmentProductDetailsBinding
import com.alexkarav.testandroidvacc24.domain.models.ProductListItemModel
import com.alexkarav.testandroidvacc24.presentation.viewmodels.ProductDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private var binding: FragmentProductDetailsBinding? = null
    private val args: ProductDetailsFragmentArgs by navArgs()
    private var productDetails: ProductListItemModel? = null
    private val viewModel: ProductDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(inflater)
        viewModel.loadProductDetails(args.productId)
        lifecycleScope.launch {
            viewModel.productDetails.collectLatest {
                productDetails = it
                binding?.productName?.text = productDetails?.title
                binding?.productImage?.load(productDetails?.image)
                binding?.productDescription?.text = productDetails?.description
                binding?.productPrice?.text = productDetails?.price.toString()
                binding?.productRating?.text = productDetails?.rating.toString()
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