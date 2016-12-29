package com.yorki.adlooperbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import com.github.yz.LoopViewPagerLayout;
import com.github.yz.entity.LoopStyle;

public class MainActivity extends AppCompatActivity {

    private LoopViewPagerLayout mLoopViewPagerLayout;
    private ArrayList<String> imageUris;
    ArrayList<LoopViewPagerLayout.BannerInfo> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mLoopViewPagerLayout = (LoopViewPagerLayout) findViewById(R.id.mLoopViewPagerLayout);
        mLoopViewPagerLayout.initializeView();//初始化View
        mLoopViewPagerLayout.setLoop_ms(3000);//轮播的速度(毫秒)
        mLoopViewPagerLayout.setLoop_duration(500);//滑动的速率(毫秒)
        mLoopViewPagerLayout.setLoop_style(LoopStyle.Empty);//轮播的样式-默认empty
        mLoopViewPagerLayout.initializeData(MainActivity.this);//初始化数据
        mLoopViewPagerLayout.setLoopData(data, new LoopViewPagerLayout.OnBannerItemClickListener() {
            @Override
            public void onBannerClick(int index, ArrayList<LoopViewPagerLayout.BannerInfo> banner) {
                Toast.makeText(MainActivity.this, "position" + index + " is clicked!", Toast.LENGTH_SHORT).show();
            }
        }, new LoopViewPagerLayout.OnLoadImageViewListener() {
            @Override
            public void onLoadImageView(ImageView view, Object object) {
                String url = (String) object;
                Glide.with(MainActivity.this)
                        .load(url)
                        .crossFade()
                        .centerCrop()
                        .into(view);
            }
        });
        mLoopViewPagerLayout.startLoop();
    }

    private void initData() {
        imageUris = new ArrayList<String>();
        imageUris
                .add("http://car3.autoimg.cn/cardfs/product/g14/M03/89/E4/u_autohomecar__wKjByVdFe2aAdF2WAAolcSOJ8-E760.jpg");
        imageUris
                .add("http://car3.autoimg.cn/cardfs/product/g14/M0F/8B/BC/u_autohomecar__wKgH5FdFe2aAXJrOAAlgdmXrzt4856.jpg");
        imageUris
                .add("http://car3.autoimg.cn/cardfs/product/g22/M12/6D/5F/u_autohomecar__wKgFVldFe2WAKJ9pAAobbMJ5rCg888.jpg");
        imageUris
                .add("http://car2.autoimg.cn/cardfs/product/g22/M04/6C/EB/u_autohomecar__wKgFW1dFe2SAUD9SAAnJ6lbVrAo619.jpg");

        data.add(new LoopViewPagerLayout.BannerInfo<String>(imageUris.get(0), "第1张图片"));
        data.add(new LoopViewPagerLayout.BannerInfo<String>(imageUris.get(1), "第2张图片"));
        data.add(new LoopViewPagerLayout.BannerInfo<String>(imageUris.get(2), "第3张图片"));
        data.add(new LoopViewPagerLayout.BannerInfo<String>(imageUris.get(3), "第4张图片"));
    }
}
