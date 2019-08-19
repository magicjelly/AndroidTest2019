package com.example.viewpager2fragments.apptray

// add import to remove a lot of inflating code
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.viewpager2fragments.R
import com.example.viewpager2fragments.apptrayitems.AppItem
import kotlinx.android.synthetic.main.app_tray_fragment.*

class AppTrayFragment : Fragment() {

/*    companion object {
        private const val MY_BOOLEAN = "my_boolean"
        private const val MY_INT = "my_int"

        fun newInstance(aBoolean: Boolean, anInt: Int) = AppTrayFragment().apply {
            arguments = Bundle(2).apply {
                putBoolean(MY_BOOLEAN, aBoolean)
                putInt(MY_INT, anInt)
            }
        }


    }*/

/*
    companion object {
        fun newInstance(foo: Int, bar: String) = MyFragment().withArgs {
            putInt(FOO, foo)
            putString(BAR, bar)
        }
    }
*/

    //private val appsAdapter by androidLazy { AppTrayFragmentAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // because of import kotlinx.android.synthetic.main.apps_fragment.* we can remove all this code and add a bit to onActivityCreated
        //return container?.inflate(R.layout.app_tray_fragment)

        //val view = inflater.inflate(R.layout.app_tray_fragment, container, false)
        //val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        return inflater.inflate(R.layout.app_tray_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        apps_grid_rv.apply {
            setHasFixedSize(true)
            val gridLayout = GridLayoutManager(context, 4)
            layoutManager = gridLayout
            //clearOnScrollListeners()
            //addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        }

        /* appsGridRV  is the id from layout file and its non-nullable object so we can use it in our code without the “?” question mark
        This could be a problem if you run this code in another part of the Activity lifecycle
        and the view was not previously inflated, this will throw an exception at runtime*/

        //apps_grid_rv.setHasFixedSize(true) // The lazy block will be executed when we use it for the first time. HERE
        // apps_grid_rv.layoutManager = GridLayoutManager(context, 4)

        initAdapter()

        // test content for apps
        if (savedInstanceState == null) {
            val apps = mutableListOf<AppItem>()
            for (i in 1..60) {

                apps.add(
                    AppItem(
                        "App $i",
                        "http://lorempixel.com/200/200/technics/$i"
                    )
                )
            }
            (apps_grid_rv.adapter as AppTrayItemAdapter).addApps(apps)
        }


    }

    private fun initAdapter() {
        if (apps_grid_rv.adapter == null) {
            apps_grid_rv.adapter = AppTrayItemAdapter()
        }
    }

    companion object {

        // Method for creating new instances of the fragment
        fun newInstance(position: Int): AppTrayFragment {

            // Store the movie data in a Bundle object
            val args = Bundle()
            //args.putString(MovieHelper.KEY_TITLE, movie.title)
            //  args.putInt(MovieHelper.KEY_RATING, movie.rating)
            // args.putString(MovieHelper.KEY_POSTER_URI, movie.posterUri)
            // args.putString(MovieHelper.KEY_OVERVIEW, movie.overview)

            // Create a new MovieFragment and set the Bundle as the arguments
            // to be retrieved and displayed when the view is created
            val fragment = AppTrayFragment()
            fragment.arguments = args
            return fragment
        }
    }

}