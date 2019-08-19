package com.example.viewpager2fragments.apptray

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AppTrayFragmentAdapter(f: Fragment) : FragmentStateAdapter(FragmentActivity()) {
    override fun createFragment(position: Int): Fragment {
        return AppTrayFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return 1
    }
}
