package com.example.viewpager2fragments.apptray

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpager2fragments.Helper

class TestPagerAdapter(fragmentManger: FragmentManager) :
    FragmentPagerAdapter(fragmentManger, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getPageTitle(position: Int): CharSequence? {
        return Helper.TITLE_LIST[position]
        //return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return Helper.TITLE_LIST.count()
    }

    override fun getItem(position: Int): Fragment {
        return AppTrayFragment.newInstance(position)
    }


}
