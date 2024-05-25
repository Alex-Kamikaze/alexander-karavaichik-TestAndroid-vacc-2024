package com.alexkarav.testandroidvacc24.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alexkarav.testandroidvacc24.databinding.ShopListItemBinding
import com.alexkarav.testandroidvacc24.domain.models.ProductListItemModel

class ShopListAdapter(private var itemList: List<ProductListItemModel>): RecyclerView.Adapter<ShopListAdapter.ViewHolder>() {

    var onItemClick: ((ProductListItemModel) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListAdapter.ViewHolder {
        return ViewHolder(ShopListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ShopListAdapter.ViewHolder, position: Int) {
        holder.binding.productName.text = itemList[position].title
        holder.binding.productPrice.text = itemList[position].price.toString()
        holder.binding.productImage.load(itemList[position].image)
        holder.binding.productRating.text = itemList[position].rating.toString()

    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class ViewHolder(val binding: ShopListItemBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(itemList[adapterPosition])
            }
        }
    }

    fun updateData(newProductList: List<ProductListItemModel>) {
        itemList = newProductList
        notifyDataSetChanged()
    }
}