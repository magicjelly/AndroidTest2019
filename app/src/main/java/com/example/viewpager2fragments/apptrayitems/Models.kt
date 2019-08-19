package com.example.viewpager2fragments.apptrayitems

data class AppItem(
    //val author: String,
    val appName: String,
    //val numComments: Int,
    // val created: Long,
    val thumbnail: String
    //val tags: ArrayList<String>
    //val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.APP
}

data class FolderItem(
    val folderName: String,
    val thumbnail: String
) : ViewType {
    override fun getViewType() = AdapterConstants.FOLDER
}