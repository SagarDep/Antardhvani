package antardhvani.du.ac.in.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 17/2/15.
 */
public class Schedule_day_adapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Group> groups;
    int height;
    public Schedule_day_adapter(Context context, ArrayList<Group> groups, int height) {
        this.context = context;
        this.groups = groups;
        this.height = height;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Child> chList = groups.get(groupPosition).getItems();
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        Child child = (Child) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expand, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.activity_googlecards_card_imageview1);


        tv.setText(child.getName().toString());
        tv.setTextSize(13);

        return null;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<Child> chList = groups.get(groupPosition).getItems();
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Group group = (Group) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.googlecardadapter, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.activity_googlecards_card_textview);
        tv.setText(group.getName());
        tv.setTextSize(11);

        SharedPreferences sharedPreferences = context.getSharedPreferences("Prefs", 0);

        convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, this.height));
        //tv.setTypeface(Typeface.DEFAULT_BOLD);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
