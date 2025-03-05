package com.example.mobile4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile4.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragments= listOf(NewsFragment(),EventsFragment())
        val adapter=ViewPagerAdapter(fragments, supportFragmentManager,lifecycle)
        binding.viewPager.adapter=adapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            // Set tab text or icon here if needed
            when(position){
                0->tab.text=resources.getString(R.string.news)
                1->tab.text=resources.getString(R.string.events)
            }
        }.attach()
        val api = RetrofitHelper.getInstance().create(NewEventsApi::class.java)

    }
}