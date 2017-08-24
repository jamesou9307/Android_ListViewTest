package com.james.android_listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fsuser on 2017-08-24.
 */

public class CountryAdapter extends ArrayAdapter<Country>{
    private int resourceId;

    /*
    * @param context 上下文
    * @param textViewResourceId  ListView 子项布局
    * @param objects  要加载的数据
    * */
    public CountryAdapter(Context context, int textViewResourceId, List<Country> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Country country=getItem(position);//获取当前项的country实例
        View view;
        ViewHolder viewHolder;//用于对控件的实例进行缓存
        //convertView用于将之前加载好的布局进行缓存，方便以后进行重用
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.countryImage=(ImageView)view.findViewById(R.id.country_image);
            viewHolder.countryName=(TextView)view.findViewById(R.id.country_name);
            view.setTag(viewHolder);//将viewHolder存储在view中
        }
        else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();//重新获取viewHolder
        }


        /*ImageView countryImage=(ImageView)view.findViewById(R.id.country_image);
        TextView countryName=(TextView)view.findViewById(R.id.country_name);*/

        viewHolder.countryImage.setImageResource(country.getCountryId());
        viewHolder.countryName.setText(country.getCountryName());

        return view;
    }
    class ViewHolder{
        ImageView countryImage;
        TextView countryName;
    }
}
