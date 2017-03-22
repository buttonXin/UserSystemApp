package com.dopool.usersystem.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dopool.usersystem.R;
import com.dopool.usersystem.bean.TagBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

public class InterestAdapter extends BaseAdapterRV<TagBean> {


    @Override
    public RecyclerView.ViewHolder createVHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag, parent, false));
    }

    @Override
    protected void onBindVH(RecyclerView.ViewHolder holder, int pos, TagBean tagBean) {
        ((ViewHolder)holder).mName.setText(tagBean.getTag());
    }


    static class ViewHolder extends BaseAdapterRV.Holder {
        private TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.text_tag);
        }
    }
}
