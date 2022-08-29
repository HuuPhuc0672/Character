package com.example.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.billingclient.api.*
import com.bumptech.glide.Glide
import com.google.common.collect.ImmutableList

class DetailActivity : AppCompatActivity() {
    private val inapp_type_1 = "free_image_animal_15_day"
    private val inapp_type_2 = "free_image_animal_1_day"
    private val inapp_type_3 = "free_image_animal_30_day"
    private val inapp_type_4 = "free_image_animal_3_day"
    private val inapp_type_5 = "free_image_animal_7_day"

    private  var  listProductDetails :MutableList<ProductDetails> = mutableListOf()
    private lateinit var billingClient: BillingClient






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
            val imageViews: ImageView by lazy { findViewById<ImageView>(R.id.imageViews) }
            val txtGia: TextView by lazy { findViewById<TextView>(R.id.txt_gias) }
            val txtNames: TextView by lazy { findViewById<TextView>(R.id.txt_names) }
            val btnMua : TextView = findViewById(R.id.btn_mua)



        //////// Chuyen du lieu
             var bundle:Bundle?= intent.extras
             var  image :Int = bundle?.getInt("image")!!
             var  money : String= bundle?.getString("money")!!
             var  namefigure: String=bundle?.getString("namefigure")!!

            Glide.with(this).load(image).centerCrop().into(imageViews)
            txtGia.text = money.toString()
            txtNames.text = namefigure.toString()

        ///// billing

/*        /// tap1
        val purchasesUpdatedListener =
            PurchasesUpdatedListener { billingResult, purchases ->
                // To be implemented in a later section.
            }

        var billingClient = BillingClient.newBuilder(this)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases()
            .build()

        /// tap2
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode ==  BillingClient.BillingResponseCode.OK) {
                    /// tap3
                    val queryProductDetailsParams =
                        QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                ImmutableList.of(
                                    QueryProductDetailsParams.Product.newBuilder()
                                        .setProductId(inapp_type_3)
                                        .setProductType(BillingClient.ProductType.INAPP)
                                        .build()))
                            .build()

                    billingClient.queryProductDetailsAsync(queryProductDetailsParams) {
                            billingResult,
                            productDetailsList ->

                        listProductDetails=productDetailsList
                        Log.d("alo", "onBillingSetupFinished: "+productDetailsList.size)
                        // check billingResult
                        // process returned productDetailsList
                    }

                    /////////////////
                }
            }
            override fun onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        })

        //// button
        btnMua.setOnClickListener {
            val productDetailsParamsList = listOf(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                    .setProductDetails(listProductDetails[0])
                   // .setOfferToken(selectedOfferToken)
                    .build()
            )
            val billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(productDetailsParamsList)
                .build()
            val billingResult = billingClient.launchBillingFlow(this, billingFlowParams)



        }
        */

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