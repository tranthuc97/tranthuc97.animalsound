package com.thuctran.soundanimalnngcao.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thuctran.soundanimalnngcao.R
import com.thuctran.soundanimalnngcao.view.App
import com.thuctran.soundanimalnngcao.view.fragment.MainFragment
import com.thuctran.soundanimalnngcao.view.model.Animal

class ListAnimalAdapterRe(private var context: Context, private var event:View.OnClickListener) : RecyclerView.Adapter<ListAnimalAdapterRe.ClassHolder>() {

     val TAG: String = ListAnimalAdapterRe::class.java.name
    val EVENT:View.OnClickListener      //khai báo event này giống một dạng callback, nhờ thằng MainFragment Click hộ
        get() = event
    private var animal:MutableLiveData<Animal> = MutableLiveData(null)
    val ANIMAL:MutableLiveData<Animal>
        get() = animal

    //từ item_view trong res/layout ta ánh xạ thành ClassHolder(inflate)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view:View =LayoutInflater.from(context).inflate(R.layout.item_animal, parent,false)
        return ClassHolder(view)
    }

    //PT định nghĩa số lượng item để đúc
    override fun getItemCount(): Int {
        return App.INSTANCE.STORAGE.listAnimal.size
    }

    //ClassHolder lấy ở thằng class bên dưới, đây là PT đưa vào số lượng itemdata, để nhét dữ liệu tương ứng của từng data vào từng ClassHolder
    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        holder.tvAnimal.setImageBitmap(App.INSTANCE.STORAGE.listAnimal[position].idDrawable)
        holder.tvAnimal.tag = App.INSTANCE.STORAGE.listAnimal[position]

    }

    //Holder ở đây có nghĩa là đồ đựng
    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //tại đây có thể khai báo từng ĐT View tương ứng của thằng itemView. VD: var tvStoryName:TextView = itemView.findViewById(R.id.tv_story_name)
        //muốn setOnclick cho từng ĐT View khai báo thì phải đặt trong khố init
        var tvAnimal:ImageView = itemView.findViewById(R.id.iv_animal)
        init {
            itemView.setOnClickListener{
                it.startAnimation(AnimationUtils.loadAnimation(context,androidx.appcompat.R.anim.abc_fade_in))
                Log.i(TAG,"Thông tin tên con vật: "+(tvAnimal.tag as Animal).nameAnimal)
                animal.value = tvAnimal.tag as Animal
                event.onClick(it)     //từ event gọi click view
            }
        }

    }

}