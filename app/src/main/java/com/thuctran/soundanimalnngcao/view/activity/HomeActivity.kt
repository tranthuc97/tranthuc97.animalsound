package com.thuctran.soundanimalnngcao.view.activity

import com.thuctran.soundanimalnngcao.view.viewmodel.CommonVM
import com.thuctran.soundanimalnngcao.view.fragment.MainFragment
import com.thuctran.soundanimalnngcao.view.fragment.SplashFragment
import com.thuctran.soundanimalnngcao.databinding.ActivityHomeBinding

class HomeActivity : BaseAct<ActivityHomeBinding, CommonVM>() {
    override fun getClassVM(): CommonVM {
        return CommonVM()
    }

    override fun initViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        showFragment(SplashFragment().TAG,null,false)       //show splash lên trước



    }

    override fun callBack(key: String, data: Any?) {
        //do something
    }

    override fun closeApp() {
        //do something
    }
}