package com.dopool.usersystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dopool.usersystem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yao on 2017/3/21.
 */

public class DeviceAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private ArrayList<String> mData=new ArrayList<>();

    public DeviceAdapter(Context mContext) {
        context = mContext;
        this.mInflater=LayoutInflater.from(context);
    }
    public void cleanData(){
        mData.clear();
    }

    public void addData(List data){
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView=mInflater.inflate(R.layout.item_device,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.mactext.setText(mData.get(position));
        holder.mactext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }

    class ViewHolder{
        public TextView mactext;
        public ViewHolder(View view) {
            mactext= (TextView) view.findViewById(R.id.item_tv);
        }
    }

}
