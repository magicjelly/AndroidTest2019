package com.example.viewpager2fragments.apptrayitems

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2fragments.R
import com.example.viewpager2fragments.inflate
import com.example.viewpager2fragments.loadImg
import kotlinx.android.synthetic.main.folder_item.view.*


class FolderDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        FolderViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as FolderViewHolder
        holder.bind(item as FolderItem)

    }

    class FolderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.folder_item)
    ) {

        private val imgThumbnail = itemView.folder_icon
        private val folderName = itemView.folder_name

        fun bind(item: FolderItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            imgThumbnail.loadImg(item.thumbnail)
            folderName.text = item.folderName
            //description.text = item.title
            //author.text = item.author
            //comments.text = "${item.numComments} comments"
            //time.text = item.created.getFriendlyTime()
        }
    }

}