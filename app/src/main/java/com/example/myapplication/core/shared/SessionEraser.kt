package com.example.myapplication.core.shared

import android.content.Context
import com.example.myapplication.core.shared.persets.PerSet

class SessionEraser {

    fun clean(session: Boolean, context: Context){
        if(session){
            PerSet(context).sessionName = null;
        }
        //todo DataBaseHandler.clean();
        //todo DefSet.clean();
        //todo Brand.clean();
    }

}