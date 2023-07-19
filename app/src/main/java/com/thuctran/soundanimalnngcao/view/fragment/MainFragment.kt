package com.thuctran.soundanimalnngcao.view.fragment

import android.graphics.Bitmap
import android.util.Log
import androidx.fragment.app.viewModels
import com.thuctran.soundanimalnngcao.databinding.M003FragmentMainBinding
import com.thuctran.soundanimalnngcao.view.App
import com.thuctran.soundanimalnngcao.view.adapter.ListAnimalAdapterRe
import com.thuctran.soundanimalnngcao.view.model.Animal
import com.thuctran.soundanimalnngcao.view.viewmodel.MainFragmentVM

@Suppress("CAST_NEVER_SUCCEEDS")
class MainFragment : BaseFragment<M003FragmentMainBinding>() {
    val TAG: String = MainFragment::class.java.name
    private var adapter: ListAnimalAdapterRe? = null
    override val viewModel by viewModels<MainFragmentVM>()    //phải khai báo như thế này thì mới sd được viewmodel trong Flagment

    override fun initViewBinding(): M003FragmentMainBinding {
        return M003FragmentMainBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding!!.rvListAnimal.removeAllViewsInLayout()
        if(App.INSTANCE.STORAGE.listAnimal.isEmpty()){          //kiểm tra nếu như kho listAnimal trống thì mới add
            viewModel.addAnimal()
        }
        Log.i(TAG, "list Animal: " + App.INSTANCE.STORAGE.listAnimal.size)

        adapter = ListAnimalAdapterRe(context1!!) {     //chỗ này là chỗ nhờ click hộ
            Log.i(TAG,"thông tin: ${adapter!!.ANIMAL.value}")
            adapter!!.ANIMAL.observe(this) {
                showDetail(it)
            }
        }
        binding!!.rvListAnimal.adapter = adapter
    }

    private fun showDetail(animal: Animal) {
        App.INSTANCE.STORAGE.animal = animal            //gán con vật animal vào trong kho

        callBack1!!.showFragment(DetailFragment().TAG, null,true)
    }
}