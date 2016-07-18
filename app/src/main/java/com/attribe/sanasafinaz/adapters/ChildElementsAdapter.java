package com.attribe.sanasafinaz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.attribe.sanasafinaz.R;
import com.attribe.sanasafinaz.models.Menu;

import java.util.List;

/**
 * Created by Maaz on 7/18/2016.
 */
public class ChildElementsAdapter extends RecyclerView.Adapter<ChildElementsAdapter.MyViewHolder> {

    Context mContext;
    private List<Menu> childCategoryElementList;
    OnChildCategoryElementClickListner childCategoryElementClickListner;


    public ChildElementsAdapter(Context mContext, List<Menu> childCategoryElementList) {
        this.mContext = mContext;
        this.childCategoryElementList = childCategoryElementList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView childCategoryElement_name;

        public MyViewHolder(View view) {
            super(view);

            childCategoryElement_name = (TextView) view.findViewById(R.id.childCategoryElement_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(childCategoryElementClickListner != null){
                childCategoryElementClickListner.onChildClick(v, getPosition());
            }
        }
    }

    public interface OnChildCategoryElementClickListner {

        void onChildClick(View view, int position);
    }

    public void SetOnItemClickListner(final OnChildCategoryElementClickListner childCategoryElementClickListner){

        this.childCategoryElementClickListner = childCategoryElementClickListner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_childcategory_element_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Menu childCategoryElement = childCategoryElementList.get(position);
        holder.childCategoryElement_name.setText("" + childCategoryElement.getName());
    }

    @Override
    public int getItemCount() { return childCategoryElementList.size(); }

}
