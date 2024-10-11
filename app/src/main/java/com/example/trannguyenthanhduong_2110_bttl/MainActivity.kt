package com.example.trannguyenthanhduong_2110_bttl

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragment.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        bottomNavigationView = findViewById(R.id.botton_navigation)

        val adapter = ViewPagerAdapter(supportFragmentManager, androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPager.adapter = adapter

        // Xử lý thay đổi trang
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Xử lý khi trang đang cuộn
            }

            override fun onPageSelected(position: Int) {
                // Chọn item tương ứng trên BottomNavigationView
                when (position) {
                    0 -> bottomNavigationView.menu.findItem(R.id.menu_profile).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.menu_menu).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.menu_setting).isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                // Xử lý thay đổi trạng thái cuộn
            }
        })

        // Xử lý sự kiện chọn item trên BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_profile -> viewPager.currentItem = 0
                R.id.menu_menu -> viewPager.currentItem = 1
                R.id.menu_setting -> viewPager.currentItem = 2
            }
            true
        }
    }
}
