package com.example.viewpager2fragments.apptray

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TestFragmentAdapter(fragmentManger: FragmentManager, lifeCycle: Lifecycle) :
    FragmentStateAdapter(fragmentManger, lifeCycle) {
    override fun createFragment(position: Int): Fragment {
        return AppTrayFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return 3
    }
}
