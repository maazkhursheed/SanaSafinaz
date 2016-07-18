package com.attribe.sanasafinaz.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.attribe.sanasafinaz.R;
import com.attribe.sanasafinaz.adapters.ParentCategoryAdapter;
import com.attribe.sanasafinaz.models.ChildCategory;
import com.attribe.sanasafinaz.models.ParentCategory;
import com.attribe.sanasafinaz.network.RestClient;
import com.attribe.sanasafinaz.utils.Constants;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Maaz on 7/14/2016.
 */
public class ParentCategoryFragment  extends Fragment {

    private ProgressDialog progressDialog;
    ParentCategoryAdapter parentCategoryAdapter;
    private GridLayoutManager layout_parentCategory;
    RecyclerView recyclerView_parentCategory;
    ParentCategory parentCategory;
    private ArrayList<ParentCategory> parent_categoriesList = new ArrayList<ParentCategory>();

    public ParentCategoryFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_categoryparent, container, false);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
         layout_parentCategory = new GridLayoutManager(getActivity(),2);

         recyclerView_parentCategory = (RecyclerView)rootView.findViewById(R.id.recyclerView_categoryParent);
         recyclerView_parentCategory.setHasFixedSize(true);
         recyclerView_parentCategory.setLayoutManager(layout_parentCategory);

         syncData();

         return rootView;
    }

    private void syncData() {
        showProgress("Getting all your products ....");

        RestClient.getAdapter().syncData(new Callback<ArrayList<ParentCategory>>() {
            @Override
            public void success(final ArrayList<ParentCategory> categoriesParent, Response response) {
                hideProgress();
                categoriesParent.size();
                parentCategoryAdapter = new ParentCategoryAdapter(getActivity(),categoriesParent);
                recyclerView_parentCategory.setAdapter(parentCategoryAdapter);

                parentCategoryAdapter.SetOnParentCategoryClickListner(new ParentCategoryAdapter.OnParentCategoryClickListner() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Bundle data = new Bundle();
                        ParentCategory categoryParent = categoriesParent.get(position);
                        data.putSerializable("ParentCategory_id", (Serializable) categoryParent);
//                        data.putInt("ParentCategory_id", categoryParent.getId());
                        ChildCategoryFragment childCategoryFragment = new ChildCategoryFragment();
                        childCategoryFragment.setArguments(data);
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_container, childCategoryFragment).commit();
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), Constants.Server_Error, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showProgress(String message){ progressDialog= ProgressDialog.show(getActivity(),"",message,false); }

    private void hideProgress(){ progressDialog.dismiss(); }

//    private class ParentCategoryListner implements View.OnTouchListener {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//
//            int categoryPosition = recyclerView_parentCategory.indexOfChild(v);
//            sendParentCategoryId(parent_categoriesList.get(categoryPosition).getId()) ;
//            return false;
//        }
//    }

//    private void sendParentCategoryId(int catId) {
//
//        Bundle bundle=new Bundle();
//        bundle.putInt("ParentCategory_id",catId);
//        ChildCategoryFragment childCategoryFragment = new ChildCategoryFragment();
//        childCategoryFragment.setArguments(bundle);
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.frame_container, childCategoryFragment).commit();
//    }

}
