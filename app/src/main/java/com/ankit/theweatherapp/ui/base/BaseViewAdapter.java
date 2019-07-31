package com.ankit.theweatherapp.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public abstract class BaseViewAdapter<T> extends RecyclerView.Adapter<BaseViewAdapter.BaseViewHolder> {
    private ViewDataBinding mBinding;
    private List<T> items;

    public BaseViewAdapter() {
        items = new ArrayList<>();
    }

    protected ViewDataBinding binding(LayoutInflater inflater, ViewGroup container, int layoutId) {
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        return mBinding;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, viewType, parent, false);
        return new BaseViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewAdapter.BaseViewHolder holder, int position) {

        onBind(holder.binding, position, items.get(position));
    }

    public abstract void onBind(ViewDataBinding binding, int position, T items);

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public BaseViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
