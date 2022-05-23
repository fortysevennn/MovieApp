package com.app.tugaypamuk.movieapp.peresention.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.app.tugaypamuk.movieapp.peresention.ui.home.HomeAdapter
import com.app.tugaypamuk.movieapp.peresention.ui.home.HomeFragment
import javax.inject.Inject

/*
class BaseFragmentFactory @Inject constructor(
    private val homeAdapter: HomeAdapter
) : FragmentFactory(){
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            //HomeFragment::class.java.name -> HomeFragment(homeAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}
 */
