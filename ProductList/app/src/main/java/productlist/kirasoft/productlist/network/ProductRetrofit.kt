package productlist.kirasoft.productlist.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by dakotajustin on 11/29/16.
 *
 * generic static class for retrofit construction
 */
class ProductRetrofit {

    private val BASEURL = "http://ads.appia.com/"

    //generic retrofit service creator
    //this is a pattern I love to follow in many of my apps
    internal fun <T> createRetrofitService(clazz: Class<T>): T {
        val restAdapter = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        val service = restAdapter.create(clazz)

        return service
    }
}