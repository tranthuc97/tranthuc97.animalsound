package com.thuctran.soundanimalnngcao.view.model

import android.graphics.Bitmap

class Animal(private var idDra: Bitmap?, private var name: String, private var idSou: String?) {
    val idDrawable: Bitmap?
        get() = idDra

    val nameAnimal: String
        get() = name

    val idSound: String?
        get() = idSou


    override fun equals(other: Any?): Boolean {
        val animal: Animal = other as Animal
        return name.equals(animal.name, true)
    }

    constructor(name: String) : this(null, name, null) {
        this.name = nameAnimal
    }

    override fun toString(): String {
        return idDra.toString()+","+name+","+idSou
    }
}