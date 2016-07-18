package com.attribe.sanasafinaz.network;

import com.attribe.sanasafinaz.models.ParentCategory;
import retrofit.Callback;
import retrofit.http.GET;

import java.util.ArrayList;

/**
 * Created by Maaz on 7/14/2016.
 */
public interface ApiInterface {

    public static String URL_SYNC ="/categories/sync_for_sana_safinaz";

    @GET(URL_SYNC)
    void syncData(Callback<ArrayList<ParentCategory>> callback);
}
