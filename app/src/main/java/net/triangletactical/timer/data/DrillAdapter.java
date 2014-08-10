package net.triangletactical.timer.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DrillAdapter extends BaseAdapter {
    private List<Drill> drills;
    private Context context;
    private int layoutResId, textResId1, textResId2;

    public DrillAdapter(Context context, int layoutResId, int textResId1, int textResId2, List<Drill> drills) {
        this.context = context;
        this.layoutResId = layoutResId;
        this.textResId1 = textResId1;
        this.textResId2 = textResId2;
        this.drills = drills;
    }

    @Override
    public int getCount() {
        return drills.size();
    }

    @Override
    public Object getItem(int position) {
        return drills.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutResId, null);
            DrillViewHolder holder = new DrillViewHolder();
            holder.title = (TextView) convertView.findViewById(textResId1);
            holder.description = (TextView) convertView.findViewById(textResId2);
            convertView.setTag(holder);
        }

        DrillViewHolder holder = (DrillViewHolder) convertView.getTag();
        Drill item = (Drill) getItem(position);
        holder.title.setText(item.title);
        holder.description.setText(item.getDescription());

        return convertView;
    }

    private static class DrillViewHolder {
        TextView title;
        TextView description;
    }
}
