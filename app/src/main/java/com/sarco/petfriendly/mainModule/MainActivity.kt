package com.sarco.petfriendly.mainModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sarco.petfriendly.R
import com.sarco.petfriendly.databinding.ActivityMainBinding
import com.sarco.petfriendly.homeModule.HomeFragment
import com.sarco.petfriendly.profileModule.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mActiveFragment: Fragment
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupBottomNavBar()

    }

    private fun setupBottomNavBar() {
        mFragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()

        mActiveFragment = homeFragment

        mFragmentManager.beginTransaction()
            .add(R.id.main_frame_layout , profileFragment, ProfileFragment::class.java.name)
            .hide(profileFragment).commit()
        mFragmentManager.beginTransaction()
            .add(R.id.main_frame_layout, homeFragment, HomeFragment::class.java.name)
            .commit()

        mBinding.bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_list -> showFragment(homeFragment)
                R.id.menu_profile -> showFragment(profileFragment)
                else -> false
            }
        }
    }

    private fun showFragment(fragment: Fragment): Boolean{
        mFragmentManager.beginTransaction().hide(mActiveFragment).show(fragment).commit()
        mActiveFragment = fragment
        return true
    }

    fun bottomNavBar(){
        mBinding.bottomNav.apply {
            if(this.visibility == View.VISIBLE)
                visibility = View.GONE
            else visibility = View.VISIBLE

        }
    }
}