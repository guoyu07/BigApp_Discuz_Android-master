package com.appbyme.app272523.main.base.activity;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.kit.utils.DialogUtils;
import com.youzu.android.framework.ViewUtils;
import com.appbyme.app272523.R;
import com.appbyme.app272523.app.config.BuildType;
import com.appbyme.app272523.base.net.LoadEmojiUtils;
import com.appbyme.app272523.base.util.theme.ThemeUtils;

/**
 * Created by Zhao on 15/9/15.
 */
public class BaseSlidingActivity extends SlidingFragmentActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeUtils.printAppStyle(this);

        initTheme();
        ViewUtils.inject(this);

        LoadEmojiUtils.startLoadSmiley(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        showDialog();
    }

    public void initTheme() {
        ThemeUtils.initTheme(this);
    }

    public void showDialog() {
        if (getString(R.string.build_type).equals(BuildType.TEST)) {
            DialogUtils.showDialog(this, getString(R.string.tips), getString(R.string.notice_test_build), getString(R.string.confirm), getString(R.string.cancel), true, true, null, null);
        }
    }

}
