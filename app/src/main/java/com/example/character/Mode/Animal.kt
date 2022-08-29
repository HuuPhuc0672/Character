package com.example.character.Mode

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

 class Animal{
     @DrawableRes val imgedv:String
     val nameanimal : String


     constructor(imgedv: String, nameanimal: String) {
         this.imgedv = imgedv
         this.nameanimal = nameanimal
     }
 }