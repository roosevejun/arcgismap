package com.smooth.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.esri.android.map.Layer;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.google.inject.Inject;
import com.smooth.R;
import org.androidannotations.annotations.*;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.fragment
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/28-10:47
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EFragment(R.layout.fragment_news_father)
public class NewsFatherFragment extends Fragment {
    @Inject
    Context context;
    @FragmentByTag("newsPop")
    NewsPopFragment mPopView;
    @ViewById(R.id.child_fragment)
    FrameLayout frameLayout;
    @ViewById(R.id.map)
    MapView mMapView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @AfterViews
    void afterViews() {
        Layer layer=new ArcGISTiledMapServiceLayer(
                "http://gis.ncgl.cn/arcgis/rest/services/ahsjcl/MapServer") ;
        mMapView.addLayer(layer);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMapView != null)
        {
            mMapView.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMapView != null)
        {
            mMapView.unpause();
        }
    }
}
