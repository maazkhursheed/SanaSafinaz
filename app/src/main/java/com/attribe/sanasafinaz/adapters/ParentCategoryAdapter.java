package com.attribe.sanasafinaz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.sanasafinaz.R;
import com.attribe.sanasafinaz.models.ParentCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Maaz on 7/14/2016.
 */
public class ParentCategoryAdapter extends RecyclerView.Adapter<ParentCategoryAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<ParentCategory> parentCategoryArrayList;
    OnParentCategoryClickListner parentCategoryClickListner;

    public ParentCategoryAdapter(Context context, ArrayList<ParentCategory> parentCategoryArrayList) {
        this.mContext = context;
        this.parentCategoryArrayList = parentCategoryArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView parentCategoryName;
        ImageView parentCategoryImage;

        public MyViewHolder(View view) {
            super(view);

            parentCategoryName = (TextView) view.findViewById(R.id.grid_item_categoryParent_name);
            parentCategoryImage = (ImageView) view.findViewById(R.id.grid_item_categoryParent_image);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(parentCategoryClickListner != null){

                parentCategoryClickListner.onItemClick(v, getPosition());
            }
        }
    }


    public interface OnParentCategoryClickListner {

        void onItemClick(View view, int position);
    }

    public void SetOnParentCategoryClickListner(final OnParentCategoryClickListner parentCategoryClickListner){

        this.parentCategoryClickListner = parentCategoryClickListner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_categoryparent, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ParentCategory parentCategory = parentCategoryArrayList.get(position);

        holder.parentCategoryName.setText("" + parentCategory.getName());

        if(parentCategory.getImage() != null) {
            String url = parentCategory.getImage();
            Picasso.with(mContext).load(url).placeholder(R.drawable.progress_animation) .error(R.drawable.catparent_bg)
                                  .resize(294,294).centerCrop().into(holder.parentCategoryImage);
        }else{
            holder.parentCategoryImage.setBackgroundResource(R.drawable.catparent_bg);
        }
    }

    @Override
    public int getItemCount() {
        return parentCategoryArrayList.size();
    }

}
