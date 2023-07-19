package com.thuctran.soundanimalnngcao.view.adapter

import android.content.Context
import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.viewpager.widget.PagerAdapter
import com.thuctran.soundanimalnngcao.view.model.Animal
import com.thuctran.soundanimalnngcao.R
import com.thuctran.soundanimalnngcao.view.App
import java.net.URLEncoder

class DetailAnimalAdapterPg(private var context: Context)  : PagerAdapter() {

    //xác định số lượng item cần đúc
    override fun getCount(): Int {
        return App.INSTANCE.STORAGE.listAnimal.size
    }

    //ánh xạ item_view vào code và đổ dữ liệu từ data vào
    override fun instantiateItem(viewPager: ViewGroup, position: Int): Any {
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_detail_animal,viewPager,false)
        var data: Animal = App.INSTANCE.STORAGE.listAnimal[position]       //lấy data thuộc Model<Any> ở vị trí position
        //ánh xạ từng đối tượng View của layout kia ra và set dữ liệu data cho nó

        val Img:ImageView =view.findViewById(R.id.iv_animalDetail)
        var bm:Bitmap = Img.drawable.toBitmap()         //chuyển từ Image qua Bitmap, ta gọi thông qua drawable
        var text:TextView = view.findViewById(R.id.tv_titleDtail)
        var ivSound:ImageView = view.findViewById(R.id.iv_sound)
        var ivSearch:ImageView = view.findViewById(R.id.iv_search)

        Img.setImageBitmap(data.idDrawable)
        text.text = data.nameAnimal

        var sound = data.idSound
        ivSound.setOnClickListener{
            var afd: AssetFileDescriptor = App.INSTANCE.assets.openFd("sound/$sound")        //PT chạy MediaPlayer từ một đường dẫn (String)
            var player = MediaPlayer()
            player.setDataSource(afd.fileDescriptor,afd.startOffset,afd.length)
            player.prepare()
            player.start()
        }

        ivSearch.setOnClickListener{
            searchGoogle(data.nameAnimal)
        }

        viewPager.addView(view)     //set xong dữ liệu rồi thì nhét cái view vừa ánh xạ kia vào viewPager
        return view
    }

    private fun searchGoogle(nameAnimal: String) {
        val word:String = URLEncoder.encode(nameAnimal,"UTF-8")
        val uri: Uri = Uri.parse("https://www.google.com/search?hl=en&q=$word")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(context,intent,null)
    }

    //so sánh 2 view cũ và mới, nếu view mới chiếm tỉ lệ quá 1/2 thì view mới xuất hiện, ngược lại thì giữ nguyên view cũ
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`     //so sánh view mới và view cũ
    }

    //Hủy itemView khi nó ra khỏi màn hình
    override fun destroyItem(viewPager: ViewGroup, position: Int, `object`: Any) {
        viewPager.removeView(`object` as View)      //view out ra khỏi màn hình thì sẽ remove nó
    }

}