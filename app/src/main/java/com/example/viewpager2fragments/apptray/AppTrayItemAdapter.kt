package com.example.viewpager2fragments.apptray

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2fragments.apptrayitems.*

class AppTrayItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
/*    private val folderItem = object : ViewType {
        override fun getViewType() = AdapterConstants.FOLDER
    }*/

    init {
        delegateAdapters.put(
            AdapterConstants.APP,
            AppDelegateAdapter()
        )
/*        delegateAdapters.put(
            AdapterConstants.FOLDER,
            FolderDelegateAdapter()
        )*/
        items = ArrayList()
        //items.add(folderItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))?.onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }

    fun addApps(apps: List<AppItem>) {
        // first remove loading and notify
        //val initPosition = items.size - 1
        //items.removeAt(initPosition)
        //notifyItemRemoved(initPosition)
        val initPosition = items.size


        // insert news and the loading at the end of the list
        items.addAll(apps)
        //items.add(folderItem)
        //notifyItemRangeChanged(initPosition, items.size + 1 /* plus loading item */)
        notifyItemRangeChanged(initPosition, items.size)
    }

    fun clearAndAddApps(news: List<AppItem>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(news)
        //items.add(folderItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getApps(): List<AppItem> {
        return items
            .filter { it.getViewType() == AdapterConstants.APP }
            .map { it as AppItem }
    }

    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex

}