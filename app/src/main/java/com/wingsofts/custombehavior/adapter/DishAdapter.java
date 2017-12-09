package com.wingsofts.custombehavior.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wingsofts.custombehavior.R;
import com.wingsofts.custombehavior.model.DishModel;

import java.util.List;

/**
 * @author wuzhenpeng03 (wuzhenpeng03@didichuxing.com)
 */
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder> {
    private Context mContext;
    private List<DishModel> mData;
    private LayoutInflater mInflater;

    public DishAdapter(Context context, List<DishModel> data) {
        this.mContext = context;
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_dish, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mName.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;

        public ViewHolder(View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.tv_name);
        }
    }
}
