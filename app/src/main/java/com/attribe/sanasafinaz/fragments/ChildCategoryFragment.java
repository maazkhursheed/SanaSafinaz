package com.attribe.sanasafinaz.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.sanasafinaz.R;
import com.attribe.sanasafinaz.adapters.ChildCategoryAdapter;
import com.attribe.sanasafinaz.models.ChildCategory;
import com.attribe.sanasafinaz.models.ParentCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maaz on 7/15/2016.
 */
public class ChildCategoryFragment extends Fragment {

    RecyclerView recyclerView_childCategory;
    ParentCategory parentCategory;
    private ArrayList<ChildCategory> child_categoriesList;
    ChildCategoryAdapter childCategoryAdapter;

    public ChildCategoryFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_categorychild, container, false);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        recyclerView_childCategory = (RecyclerView)rootView.findViewById(R.id.recyclerView_categoryChild);
        recyclerView_childCategory.setHasFixedSize(true);

        childCategoryList_byParentCategory();
        return rootView;
    }

    private void childCategoryList_byParentCategory() {

        Bundle bundle = getArguments();
        parentCategory = (ParentCategory) bundle.getSerializable("ParentCategory_id");
        childCategoryAdapter = new ChildCategoryAdapter(getActivity(), parentCategory.getChild_categories());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_childCategory.setLayoutManager(mLayoutManager);
        recyclerView_childCategory.setItemAnimator(new DefaultItemAnimator());
        recyclerView_childCategory.setAdapter(childCategoryAdapter);

        childCategoryAdapter.SetOnItemClickListner(new ChildCategoryAdapter.OnChildCategoryClickListner() {
            @Override
            public void onChildClick(View view, int position) {

                Bundle data = new Bundle();
                ChildCategory categoryChild = parentCategory.getChild_categories().get(position);
                data.putSerializable("ChildCategory_id", (Serializable) categoryChild);
                ChildElementsFragment childElementsFragment = new ChildElementsFragment();
                childElementsFragment.setArguments(data);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, childElementsFragment).commit();
            }
        });
    }
}
