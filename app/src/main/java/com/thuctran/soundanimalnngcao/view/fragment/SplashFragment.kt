package com.thuctran.soundanimalnngcao.view.fragment

import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import com.thuctran.soundanimalnngcao.R
import com.thuctran.soundanimalnngcao.view.viewmodel.CommonVM
import com.thuctran.soundanimalnngcao.databinding.M001FragmentSplashBinding
import com.thuctran.soundanimalnngcao.view.viewmodel.BaseViewModel

class SplashFragment : BaseFragment<M001FragmentSplashBinding>() {
    var TAG: String = SplashFragment::class.java.name


    override fun initViewBinding(): M001FragmentSplashBinding {
        return M001FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        //set animation cho View ở fragment splash
        binding!!.ivAnimal.startAnimation(AnimationUtils.loadAnimation(context1,R.anim.anim_alpha))
        binding!!.ivTitle.startAnimation(AnimationUtils.loadAnimation(context1, R.anim.anim_top_start))

        //2s sau chạy sang MainFragment
        android.os.Handler().postDelayed({
            callBack1?.showFragment(EntranceFragment().TAG,null,false)
        },6000)
    }
}