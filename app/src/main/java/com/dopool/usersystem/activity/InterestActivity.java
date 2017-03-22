package com.dopool.usersystem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.dopool.usersystem.R;
import com.dopool.usersystem.adapter.BaseAdapterRV;
import com.dopool.usersystem.adapter.InterestAdapter;
import com.dopool.usersystem.bean.TagBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

public class InterestActivity extends BaseActivity{

    private List<TagBean> mTagLists;

    @BindView(R.id.recycler_dislike)
    RecyclerView mDislikeRv;
    @BindView(R.id.recycler_like)
    RecyclerView mLikeRv;
    private InterestAdapter mLikeAdapter;
    private List<TagBean> mDisLikeList;
    private InterestAdapter mDislikeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {

        setRvManager(mLikeRv , mLikeAdapter);
        mLikeAdapter.setItemOnClickListener(new BaseAdapterRV.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, TagBean tag) {
                showToast(position + tag.getTag());
                mDislikeAdapter.addItem(tag);
            }
        });

        setRvManager(mDislikeRv , mDislikeAdapter);
        mDislikeAdapter.setItemOnClickListener(new BaseAdapterRV.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, TagBean tag) {
                showToast(position + tag.getTag());
                mLikeAdapter.addItem(tag);
            }
        });
    }

    /**
     * 配置rv的参数
     * @param recyclerView
     */
    private void setRvManager(RecyclerView recyclerView , InterestAdapter adapter) {
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager( 4 , StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sgm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    private void initData() {
        mTagLists = new ArrayList<>();
        for (int i = 0; i < 15; i++) {

            mTagLists.add(new TagBean("人文艺术"+ i));
        }
        mLikeAdapter = new InterestAdapter();
        mLikeAdapter.addData(mTagLists);


        mDisLikeList = new ArrayList<>();
        for (int i = 0; i <20; i++) {
            mDisLikeList.add(new TagBean("体育"+ i));
        }
        mDislikeAdapter = new InterestAdapter();
        mDislikeAdapter.addData(mDisLikeList);
    }
}
