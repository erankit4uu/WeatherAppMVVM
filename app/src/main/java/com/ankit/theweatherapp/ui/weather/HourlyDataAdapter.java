package com.ankit.theweatherapp.ui.weather;

import android.database.DatabaseUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.ankit.theweatherapp.R;
import com.ankit.theweatherapp.databinding.ItemHourlyDataBinding;

import java.util.List;

public class HourlyDataAdapter extends RecyclerView.Adapter<HourlyDataAdapter.MyViewHolder> {
    List<com.ankit.theweatherapp.model.List> mainList;

    public HourlyDataAdapter(List<com.ankit.theweatherapp.model.List> mainList) {
        this.mainList = mainList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_hourly_data, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyDataAdapter.MyViewHolder holder, int position) {
        holder.binding.tvHrTemp.setText(mainList.get(position).getMain().getTemp().toString());
        Log.d("adapterVIew", mainList.get(position).getMain().getTemp().toString());
    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemHourlyDataBinding binding;
        public MyViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            binding = (ItemHourlyDataBinding) viewDataBinding;
        }
    }
}
