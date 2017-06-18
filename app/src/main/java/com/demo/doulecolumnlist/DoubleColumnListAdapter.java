package com.demo.doulecolumnlist;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
public class DoubleColumnListAdapter extends BaseAdapter {

    private List<String> mListData = new ArrayList<>();
    private LayoutInflater mInflater;

    public DoubleColumnListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<String> listData){
        mListData.addAll(listData);
    }

    @Override
    public int getCount() {
        return (mListData.size()/2);
    }

    @Override
    public Object getItem(int i) {
        if(i < 0 || i >= mListData.size()) {
            return null;
        }
        return mListData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DoubleColumnListHolder holder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.double_list_item, null);
            holder=new DoubleColumnListHolder(view);
            view.setTag(holder);
        }else {
            holder = (DoubleColumnListHolder)view.getTag();
        }
        String str1 = (String)getItem(i * 2);
        String str2 = (String)getItem(i * 2 + 1);
        holder.init(str1, str2);
        return view;
    }

    public static class DoubleColumnListHolder{
        TextView mText1;
        TextView mText2;

        public DoubleColumnListHolder(View root){
            mText1 = (TextView) root.findViewById(R.id.txt_one);
            mText2 = (TextView) root.findViewById(R.id.txt_two);
        }

        public void init(String str1, String str2){
            mText1.setText(str1);
            mText2.setText(str2);
        }
    }
}
