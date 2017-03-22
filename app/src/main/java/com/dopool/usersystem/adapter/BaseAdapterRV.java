package com.dopool.usersystem.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.dopool.usersystem.bean.TagBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/9 0009.
 */

public abstract class BaseAdapterRV<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<T> mDatas = new ArrayList<>();

    private OnItemClickListener mListener ;//点击事件

    /**
     * 添加数据
     * @param datas
     */
    public void addData(List<T> datas) {
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createVHolder(parent , viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        final T t = mDatas.get(position);
        onBindVH(holder , position , t);

        if (mListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    T remove = mDatas.remove(position);
                    //notifyItemRemoved(position);
                    notifyDataSetChanged();
                    mListener.onItemClick(position , holder.itemView , (TagBean) remove);

                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return  mDatas.size()  ;
    }

    /**
     * 添加数据
     * @param t
     */
    public void addItem(T t){
        mDatas.add(mDatas.size(), t);
        //notifyItemInserted(0);
        notifyDataSetChanged();
    }

    /**
     * 删除数据
     * @param t
     */
    public void removeItem(T t){
        int position = mDatas.indexOf(t);
        mDatas.remove(position);
        notifyItemRemoved(position);
    }


    public abstract RecyclerView.ViewHolder createVHolder(ViewGroup parent, int viewType) ;
    protected abstract void onBindVH(RecyclerView.ViewHolder holder, int pos, T t);

    static abstract class Holder extends RecyclerView.ViewHolder{
        public Holder(View itemView) {
            super(itemView);
        }
    }

    public void setItemOnClickListener(OnItemClickListener listener){
        mListener = listener ;
    }

    public interface OnItemClickListener<T extends TagBean>{
        void onItemClick(int position, View view, T tag);
    }

}
