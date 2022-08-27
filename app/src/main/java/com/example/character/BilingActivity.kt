package com.example.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.billingclient.api.*

class BilingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biling)
        val btnBiling : Button= findViewById(R.id.btn_biling)

        val  skuList = ArrayList<String>()
        skuList.add("android.test.purchased")
        val  purchasesUpdatedListener = PurchasesUpdatedListener{
            billingResult, purchhses ->

        }

        var  billingClient = BillingClient.newBuilder(this)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases().build()

            btnBiling.setOnClickListener {

            billingClient.startConnection(object : BillingClientStateListener{
                override fun onBillingServiceDisconnected() {
                    TODO("Not yet implemented")
                }

                override fun onBillingSetupFinished(billingResult: BillingResult) {
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK){

                        val  params=SkuDetailsParams.newBuilder()
                        params.setSkusList(skuList)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()){ billingResult, skuDetailsList->
                            for (skDetaoils in skuDetailsList!!){
                                val flowPurchase =BillingFlowParams.newBuilder()
                                    .setSkuDetails(skDetaoils)
                                    .build()
                                val responseCode = billingClient.launchBillingFlow(this@BilingActivity,flowPurchase).responseCode
                            }

                        }

                    }




                }

            })

        }
    }
}