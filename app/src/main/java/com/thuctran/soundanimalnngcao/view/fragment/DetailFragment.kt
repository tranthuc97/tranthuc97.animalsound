package com.thuctran.soundanimalnngcao.view.fragment

import android.annotation.SuppressLint
import android.util.Log
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
import com.thuctran.soundanimalnngcao.databinding.M005FragmentViewPagerBinding
import com.thuctran.soundanimalnngcao.view.App
import com.thuctran.soundanimalnngcao.view.adapter.DetailAnimalAdapterPg

@Suppress("UNCHECKED_CAST")
class DetailFragment : BaseFragment<M005FragmentViewPagerBinding>() {
    private var index:Int = 0
    var TAG: String = DetailFragment::class.java.name

    override fun initViewBinding(): M005FragmentViewPagerBinding {
        return M005FragmentViewPagerBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetTextI18n")
    override fun initViews() {
        var adapter = DetailAnimalAdapterPg(context1!!)
        binding!!.vpDetailAnimal.adapter = adapter

        var selectedIndex:Int = App.INSTANCE.STORAGE.listAnimal!!.indexOf(App.INSTANCE.STORAGE.animal)       //lấy vị trí index của thằng storyModel được chọn
        Log.i(TAG,"vị trí con vật: $selectedIndex")
        binding!!.vpDetailAnimal.setCurrentItem(selectedIndex,true  )           //khi mở ra thì set luôn vpStory ở cái thằng storyModel được chọn
        //muốn tự động vuốt sang trang khác, gọi lại setCurrentItem(selectedIndex,true)

        binding!!.tvCount.text = selectedIndex.toString() + "/" + App.INSTANCE.STORAGE.listAnimal.size.toString()

        binding!!.vpDetailAnimal.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //do
            }

            override fun onPageSelected(position: Int) {
                binding!!.tvCount.text = position.toString() + "/" + App.INSTANCE.STORAGE.listAnimal.size.toString()
            }

            override fun onPageScrollStateChanged(state: Int) {
                //do
            }
        })
    }
}