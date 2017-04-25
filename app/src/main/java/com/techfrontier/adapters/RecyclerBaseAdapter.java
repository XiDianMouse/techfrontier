package com.techfrontier.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.techfrontier.listeners.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther gbh
 * Created on 2017/4/25.
 */

public abstract class RecyclerBaseAdapter<D,V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V>{
    protected  final List<D> mDataSet = new ArrayList<D>();//RecyclerView中的数据集
    private OnItemClickListener<D> mItemClickListener;//点击事件回调处理

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }

    protected D getItem(int position){
        return mDataSet.get(position);
    }

    public void addItems(List<D> items){
        //移除已经存在的数据,避免数据重复
        items.removeAll(mDataSet);
        //添加新数据
        mDataSet.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public final void onBindViewHolder(V viewHolder,int positon){
        final D item = getItem(positon);
        bindDataToItemView(viewHolder,item);
        setupItemViewClickListener(viewHolder,item);
    }

    protected View inflateItemView(ViewGroup viewGroup,int layoutId){
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutId,viewGroup,false);
    }

    public void setOnItemClickListener(OnItemClickListener<D> mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }

    protected void setupItemViewClickListener(V viewHolder,final D item){
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener!=null){
                    mItemClickListener.onClick(item);
                }
            }
        });
    }

    protected abstract void bindDataToItemView(V viewHolder,D item);
}
