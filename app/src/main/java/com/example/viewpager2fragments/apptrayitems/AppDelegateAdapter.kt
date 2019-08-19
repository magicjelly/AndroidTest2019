package com.example.viewpager2fragments.apptrayitems

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2fragments.R
import com.example.viewpager2fragments.inflate
import com.example.viewpager2fragments.loadImg
import kotlinx.android.synthetic.main.app_item.view.*

class AppDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        AppViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as AppViewHolder
        holder.bind(item as AppItem)
    }

    class AppViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.app_item)
    ) {

        private val imgThumbnail = itemView.app_icon
        private val appName = itemView.app_name

        fun bind(item: AppItem) = with(itemView) {
            imgThumbnail.loadImg(item.thumbnail)
            appName.text = item.appName
        }
    }

}