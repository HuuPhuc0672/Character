package com.example.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.billingclient.api.*
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {


    private val txtNames: TextView by lazy { findViewById<TextView>(R.id.txt_names) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
            val imageViews: ImageView by lazy { findViewById<ImageView>(R.id.imageViews) }
            val txtGia: TextView by lazy { findViewById<TextView>(R.id.txt_gias) }
            val btnMua : Button = findViewById(R.id.btn_mua)



        //////// Chuyen du lieu
             var bundle:Bundle?= intent.extras
             var  image :Int = bundle?.getInt("image")!!
             var  money : String= bundle?.getString("money")!!
             var  namefigure: String=bundle?.getString("namefigure")!!

            Glide.with(this).load(image).centerCrop().into(imageViews)
            txtGia.text = money.toString()
            txtNames.text = namefigure.toString()


        ////// biling


        val  skuList = ArrayList<String>()
        skuList.add("android.test.purchased")
        val  purchasesUpdatedListener = PurchasesUpdatedListener{
                billingResult, purchhses ->

        }

        var  billingClient = BillingClient.newBuilder(this)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases().build()

        btnMua.setOnClickListener {

            billingClient.startConnection(object : BillingClientStateListener {
                override fun onBillingServiceDisconnected() {
                    TODO("Not yet implemented")
                }

                override fun onBillingSetupFinished(billingResult: BillingResult) {
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK){

                        val  params= SkuDetailsParams.newBuilder()
                        params.setSkusList(skuList)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()){ billingResult, skuDetailsList->
                            for (skDetaoils in skuDetailsList!!){
                                val flowPurchase = BillingFlowParams.newBuilder()
                                    .setSkuDetails(skDetaoils)
                                    .build()
                                val responseCode = billingClient.launchBillingFlow(this@DetailActivity,flowPurchase).responseCode
                            }

                        }

                    }
                }

            })

        }


    }
}