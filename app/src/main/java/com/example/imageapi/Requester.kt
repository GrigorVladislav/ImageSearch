//package com.example.imageapi
//
//import android.app.usage.UsageEvents
//import android.content.Context
//import com.koushikdutta.ion.Ion
//import org.json.JSONArray
//import org.json.JSONObject
//import java.lang.Exception
//
//object Requester {
//
//    private var linkList = mutableListOf<String>()
//
//    fun searchImage(enterText: String, context:Context){
//        val url:String = "${Constants.searchURL + enterText + Constants.apiKey + Constants.searchEngineID}"
//
//        try {
//            var result = Ion.with(context).load(url).asString()
//                .setCallback{error, result ->
//                    var jArray = JSONObject(result).optJSONArray("items")
//                    if (jArray != null){
//                        for (i in 0..(jArray.length() - 1)) {
//                            var imgLink = jArray.getJSONObject(i).getString("link")
//                            linkList.add(imgLink)
//                        }
//                        MainActivity.Init.saveList(linkList)
//                    }
//            }
//        }catch (e:Exception){
//
//        }
//    }
//
//    private fun getLinks(jArray: JSONArray?) {
//        if (jArray != null){
//            for (i in 0..(jArray.length() - 1)) {
//                var imgLink = jArray.getJSONObject(i).getString("link")
//                linkList.add(imgLink)
//            }
//        }
//    }
//}