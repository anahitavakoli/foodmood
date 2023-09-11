package com.anahitavakoli.apps.foodmood.customView

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class FarsiEditText :
    AppCompatEditText {

    constructor(context: Context):super(context){
        val face = Typeface.createFromAsset(context.assets,"fonts/iranyekanwebregular.ttf")
        setTypeface(face)
    }

    constructor(context: Context,attrs:AttributeSet):super(context,attrs){
        val face = Typeface.createFromAsset(context.assets,"fonts/iranyekanwebregular.ttf")
        setTypeface(face)
    }

    constructor(context: Context,attrs:AttributeSet,style:Int):super(context,attrs,style){
        val face = Typeface.createFromAsset(context.assets,"fonts/iranyekanwebregular.ttf")
        setTypeface(face)
    }


}