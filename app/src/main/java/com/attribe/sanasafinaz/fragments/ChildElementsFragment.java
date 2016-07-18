package com.attribe.sanasafinaz.fragments;

import android.app.Fragment;
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
import com.attribe.sanasafinaz.adapters.ChildElementsAdapter;
import com.attribe.sanasafinaz.models.ChildCategory;

/**
 * Created by Maaz on 7/18/2016.
 */
public class ChildElementsFragment extends Fragment {

    RecyclerView recyclerView_childCategoryElements;
    ChildCategory childCategory;
    ChildElementsAdapter childElementsAdapter;

    public ChildElementsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_categorychild_elements, container, false);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        recyclerView_childCategoryElements = (RecyclerView)rootView.findViewById(R.id.recyclerView_categoryChildElements);
        recyclerView_childCategoryElements.setHasFixedSize(true);

        childCategoryElementsList_byChildCategory();
        return rootView;
    }

    private void childCategoryElementsList_byChildCategory() {

        Bundle bundle = getArguments();
        childCategory = (ChildCategory) bundle.getSerializable("ChildCategory_id");
        childElementsAdapter = new ChildElementsAdapter(getActivity(), childCategory.getMenus());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_childCategoryElements.setLayoutManager(mLayoutManager);
        recyclerView_childCategoryElements.setItemAnimator(new DefaultItemAnimator());
        recyclerView_childCategoryElements.setAdapter(childElementsAdapter);
    }
}
