package com.example.imageapi

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.koushikdutta.ion.Ion
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

//       companion object Init{
//                    var linkList = mutableListOf<String>()
//                    fun saveList(list: MutableList<String>){
//                        linkList = list
//                    }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClick()
    }

    private fun setClick(){
        search_button.setOnClickListener{
            var str = search_field.text.toString().trim()
            if (str.contains(" ")){
                Toast.makeText(this, "Enter only one word",Toast.LENGTH_SHORT).show()
            }else{
                searchImage(str)
            }
            layout_search_view.removeAllViews()

        }
    }


    fun setImageToGrid(link:String) {

        var image = ImageView(baseContext)
        image.scaleType= ImageView.ScaleType.CENTER
        var width = getApplicationContext().getResources().getDisplayMetrics().widthPixels




        Picasso.with(this).load(link).resize(300,300).into(image)
        layout_search_view.addView(image)

    }

    fun searchImage(enterText: String){
        val url:String = "${Constants.searchURL + enterText + Constants.apiKey + Constants.searchEngineID}"

        try {
            var result = Ion.with(this).load(url).asString()
                .setCallback{error, result ->
                    var jArray = JSONObject(result).optJSONArray("items")
                    if (jArray != null){
                        for (i in 0..(jArray.length() - 1)) {
                            var imgLink = jArray.getJSONObject(i).getString("link")
                            setImageToGrid(imgLink)

                        }

                    }
                }
        }catch (e: Exception){

        }
    }


}
