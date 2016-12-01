package com.yumingchuan.rsqmonthcalendar;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class MonthScheduleAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private List<ScheduleToDo> totalTodo;
    private ViewHolder holder;

    public MonthScheduleAdapter(Context mContext, List<ScheduleToDo> totalTodo) {
        super();
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.totalTodo = totalTodo;
    }

    @Override
    public int getCount() {
        return totalTodo.size();
    }

    @Override
    public Object getItem(int position) {
        return totalTodo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView != null) {
            view = convertView;
        } else {
            view = inflater.inflate(R.layout.item_week_schedule_calendar, parent, false);
        }
        holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.tv_content = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(holder);
        }


        if (totalTodo.get(position).pIsDone) {
            holder.tv_content.setText(totalTodo.get(position).pTitle);
            //holder.tv_content.setTextColor(mContext.getResources().getColor(R.color.black_a3));
            holder.tv_content.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tv_content.getPaint().setAntiAlias(true);
        } else {
            //holder.tv_content.setTextColor(mContext.getResources().getColor(R.color.black_33));
            holder.tv_content.getPaint().setFlags(0);
            holder.tv_content.getPaint().setAntiAlias(true);
            holder.tv_content.setText(totalTodo.get(position).pTitle);
        }

        return view;
    }

    private class ViewHolder {

        private TextView tv_content;// 日期

    }
}
