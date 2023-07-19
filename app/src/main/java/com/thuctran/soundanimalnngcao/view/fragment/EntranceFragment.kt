package com.thuctran.soundanimalnngcao.view.fragment

import android.view.animation.AnimationUtils
import com.thuctran.soundanimalnngcao.R
import com.thuctran.soundanimalnngcao.databinding.M002FragmentEntranceBinding

class EntranceFragment : BaseFragment<M002FragmentEntranceBinding>() {
    val TAG: String = EntranceFragment::class.java.name

    override fun initViewBinding(): M002FragmentEntranceBinding {
        return M002FragmentEntranceBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding!!.tvTittle.startAnimation(AnimationUtils.loadAnimation(context1,R.anim.anim_top_start2))
        binding!!.ivStart.startAnimation(AnimationUtils.loadAnimation(context1, R.anim.anim_start_scale))
        binding!!.ivStart.setOnClickListener{ callBack1!!.showFragment(MainFragment().TAG,null,false)}
    }
}