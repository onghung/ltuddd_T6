package com.example.myapplication.t61;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context mContext;
    private List<Product> mProductList;

    public ProductAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderT61 holder;
        if (convertView==null){//tao view moi
            //doi tuong sinh layout(trang)
            convertView= LayoutInflater.from(mContext)
                    .inflate(R.layout.item_view_t61,parent,false);
            holder=new ViewHolderT61();
            //anh xa tung truong
            holder.imageView=convertView.findViewById(R.id.item_product_imageView);
            holder.styleidTv=convertView.findViewById(R.id.item_styleid_textview);
            holder.brandTv=convertView.findViewById(R.id.item_brand_textview);
            holder.priceTv=convertView.findViewById(R.id.item_price_textview);
            holder.additionalInfoTv=convertView.findViewById(R.id.item_additionalInfo_textview);

            //tao mau de su dung
            convertView.setTag(holder);

        }else{
            //lay view cu
            holder=(ViewHolderT61) convertView.getTag();
        }

        //gan data cho view
        Product product = mProductList.get(position);
        if(product!=null){
            //display image
            Picasso.get().load(product.getSearchImage()).into(holder.imageView);
            //set data for fields thiet lap du lieu cho cac truong khac
            holder.additionalInfoTv.setText(product.getAdditionalInfo());
            holder.brandTv.setText(product.getBrand());
            holder.priceTv.setText(product.getPrice());
            holder.styleidTv.setText(product.getStyleId());
        }
        return convertView;
    }

    static class ViewHolderT61 {
        ImageView imageView;
        TextView styleidTv, brandTv, priceTv, additionalInfoTv;
    }
}
