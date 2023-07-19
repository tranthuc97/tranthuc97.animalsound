package com.thuctran.soundanimalnngcao.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.thuctran.soundanimalnngcao.view.OnMainCallBack
import com.thuctran.soundanimalnngcao.view.viewmodel.BaseViewModel

@Suppress("UNREACHABLE_CODE")
abstract class BaseFragment<V: ViewBinding> : Fragment(),OnClickListener {
    protected var binding:V? = null
    protected var context1:Context? = null
    protected var data1:Any? = null
    protected var callBack1: OnMainCallBack? = null
    protected open val viewModel by viewModels<BaseViewModel>()

    fun setData(data:Any?){
        data1 = data
    }

    fun setCallBack(callBack: OnMainCallBack) {
        callBack1 = callBack
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context1 = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initViewBinding()
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }



    abstract fun initViewBinding(): V

    abstract fun initViews()

    final override fun onClick(v: View?) {
        clickView(v)
    }

    protected open fun clickView(v: View?) {
        //do nothing
    }

    protected fun showNotify(msg: String) {
        Toast.makeText(context1, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showNotify(msg: Int) {
        Toast.makeText(context1, msg, Toast.LENGTH_SHORT).show()
    }
}