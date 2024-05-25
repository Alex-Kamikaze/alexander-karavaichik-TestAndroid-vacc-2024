package com.alexkarav.testandroidvacc24.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.alexkarav.testandroidvacc24.databinding.FragmentMainPageBinding
import com.alexkarav.testandroidvacc24.domain.mappers.RemoteProductListToListItem
import com.alexkarav.testandroidvacc24.domain.models.ProductListItemModel
import com.alexkarav.testandroidvacc24.presentation.adapters.ShopListAdapter
import com.alexkarav.testandroidvacc24.presentation.viewmodels.ShopListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainPage : Fragment() {

    private var binding: FragmentMainPageBinding? = null
    private val viewModel: ShopListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater)
        var productList = listOf<ProductListItemModel>()
        val adapter = ShopListAdapter(productList)
        lifecycleScope.launch {
            viewModel.productList.collectLatest {
                productList = RemoteProductListToListItem.intoListItem(it)
                adapter.updateData(productList)
            }
        }

        binding?.shopList?.adapter = adapter
        adapter.onItemClick = {
            findNavController().navigate(MainPageDirections.actionMainPageToProductDetailsFragment(it.id))
        }
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainPage()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}