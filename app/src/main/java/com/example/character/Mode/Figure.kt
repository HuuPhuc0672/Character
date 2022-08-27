package com.example.character.Mode

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

 class Figure{
     @DrawableRes val imge:Int
     val money: String
     val namefigure : String


     constructor(imge: Int, money: String, namefigure: String) {
         this.imge = imge
         this.money = money
         this.namefigure = namefigure
     }
 }