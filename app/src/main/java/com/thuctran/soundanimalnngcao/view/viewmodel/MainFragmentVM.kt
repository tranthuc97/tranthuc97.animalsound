package com.thuctran.soundanimalnngcao.view.viewmodel

import android.content.res.AssetFileDescriptor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.SoundPool
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thuctran.soundanimalnngcao.view.App
import com.thuctran.soundanimalnngcao.view.model.Animal
import java.io.InputStream

class MainFragmentVM : BaseViewModel() {
    var TAG: String = MainFragmentVM::class.java.name
    private var listAnimalVM: MutableLiveData<Animal> = MutableLiveData(null)
    val LISTANIMAL: MutableLiveData<Animal>
        get() = listAnimalVM

    fun addAnimal() {
        var listPhotoName: Array<String> = App.INSTANCE.assets.list("animal/")!!
        for (photoPath in listPhotoName) {
            var inImg: Bitmap =
                BitmapFactory.decodeStream(App.INSTANCE.assets.open("animal/$photoPath"))
            var nameAnimal = photoPath.replace(".png", "")
            var listSound: Array<String> = App.INSTANCE.assets.list("sound/")!!
            var index: Int = listSound.indexOf("$nameAnimal.mp3")
            var soundAnimal:String = listSound[index]
            App.INSTANCE.STORAGE.listAnimal.add(Animal(inImg, nameAnimal, soundAnimal))
        }

    }
}