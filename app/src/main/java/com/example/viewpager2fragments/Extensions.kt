@file:JvmName("ExtensionsUtils")

package com.example.viewpager2fragments

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/*What we are doing here is to add a new method to ViewGroup
(see how we add the ViewGroup with a dot before the “inflate” method name)
but we are not modifying the ViewGroup class but adding a new function.
This function will be internally a static method but you will be calling
it from an instance of a class with the dot-notation, in this case: container.inflate(…)
and not ViewGroup.inflate(). This is because the compiler will be creating a Util class for us*/

// not to use within fragment thats within viewpager
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.get().load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.get().load(imageUrl).into(this)
    }
}

fun <T> androidLazy(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)