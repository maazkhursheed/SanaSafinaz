package com.attribe.sanasafinaz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.attribe.sanasafinaz.R;
import com.attribe.sanasafinaz.models.ChildCategory;

import java.util.List;

/**
 * Created by Maaz on 7/15/2016.
 */
public class ChildCategoryAdapter extends RecyclerView.Adapter<ChildCategoryAdapter.MyViewHolder>  {

    Context mContext;
    private List<ChildCategory> childCategoryList;
    OnChildCategoryClickListner childCategoryClickListner;

    public ChildCategoryAdapter(Context mContext, List<ChildCategory> childCategoryList) {
        this.mContext = mContext;
        this.childCategoryList = childCategoryList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView childCategory_name;

        public MyViewHolder(View view) {
            super(view);

            childCategory_name = (TextView) view.findViewById(R.id.childCategory_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(childCategoryClickListner != null){
                childCategoryClickListner.onChildClick(v, getPosition());
            }
        }
    }

    public interface OnChildCategoryClickListner {

        void onChildClick(View view, int position);
    }

    public void SetOnItemClickListner(final OnChildCategoryClickListner childCategoryClickListner){

        this.childCategoryClickListner = childCategoryClickListner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_childcategory_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ChildCategory childCategory = childCategoryList.get(position);
        holder.childCategory_name.setText("" + childCategory.getName());
    }

    @Override
    public int getItemCount() { return childCategoryList.size(); }
}
