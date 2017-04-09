package com.vumobile.celeb.Utils;

import android.content.Context;
import android.content.Intent;

import com.vumobile.celeb.model.ConstantApp;
import com.vumobile.celeb.ui.BaseActivity;
import com.vumobile.celeb.ui.LiveRoomActivity;

/**
 * Created by toukirul on 6/4/2017.
 */

public class HandleRequest extends BaseActivity{

    Context mContext;

    public HandleRequest(Context context){
        this.mContext = context;
    }

    public void forwardToLiveRoom(int cRole, String celebName) {
        // here room name is celebrity name..who want to go to live

        String room = celebName;

        Intent i = new Intent(mContext, LiveRoomActivity.class);
        i.putExtra(ConstantApp.ACTION_KEY_CROLE, cRole);
        i.putExtra(ConstantApp.ACTION_KEY_ROOM_NAME, room);

        mContext.startActivity(i);
    }

    @Override
    protected void initUIandEvent() {

    }

    @Override
    protected void deInitUIandEvent() {

    }
}
