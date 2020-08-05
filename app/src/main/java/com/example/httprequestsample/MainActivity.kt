package com.example.httprequestsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val url = "http://www.google.com"
        val url = "http://192.168.11.11:3000/api"
//        val url = "http://my-json-feed"

        /** Volley.newRequestQueue を使用するパターン
         * https://developer.android.com/training/volley/simple?hl=ja */
        // Instantiate the RequestQueue.
        // RequestQueueをインスタンス化します。
        val queue = Volley.newRequestQueue(this)

        // Request a string response from the provided URL.
        // 指定されたURLから文字列応答を要求します。


        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    textView.text = "Response: %s".format(response.toString())
                },
                Response.ErrorListener { error ->
                    textView.text = "ERROR: %s".format(error.toString())
                })

        // Add the request to the RequestQueue.
        // リクエストをRequestQueueに追加します。
        queue.add(stringRequest)

        /** RequestQueue をセットアップする
         * https://developer.android.com/training/volley/requestqueue?hl=ja */
//        // Instantiate the cache
//        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
//
//        // Set up the network to use HttpURLConnection as the HTTP client.
//        val network = BasicNetwork(HurlStack())
//
//        // Instantiate the RequestQueue with the cache and network. Start the queue.
//        val requestQueue = RequestQueue(cache, network).apply {
//            start()
//        }
//
//        // Formulate the request and handle the response.
//        val stringRequest = StringRequest(Request.Method.GET, url,
//                Response.Listener<String> { response ->
//                    // Do something with the response
//                    textView.text = "ok"
//                },
//                Response.ErrorListener { error ->
//                    // Handle error
//                    textView.text = "ERROR: %s".format(error.toString())
//                })
//
//        // Add the request to the RequestQueue.
//        requestQueue.add(stringRequest)


        /** 標準リクエストを作成する
         * https://developer.android.com/training/volley/request?hl=ja */
//        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
//                Response.Listener { response ->
//                    textView.text = "Response: %s".format(response.toString())
//                },
//                Response.ErrorListener { error ->
//                    textView.text = "ERROR: %s".format(error.toString())
//                }
//        )
//
//        // Access the RequestQueue through your singleton class.
//        // シングルトンクラスを介してRequestQueueにアクセスします。
//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
}

// 出典：https://developer.android.com/training/volley?hl=ja