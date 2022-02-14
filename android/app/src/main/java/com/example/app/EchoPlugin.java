package com.example.app;

import android.content.Intent;

import androidx.activity.result.ActivityResult;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Echo")
public class EchoPlugin extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
        String value = call.getString("value");
        System.out.println("abcd" + value);
        JSObject ret = new JSObject();
        ret.put("value", value);
        Intent i = new Intent(getActivity(), BtnClickedService.class);
//        getActivity().startService(i);
//        Intent intent = new Intent(getActivity(), ImportantActivity.class);
        startActivityForResult(call, i, "getBookChatStatus");
    }
    @ActivityCallback
    public void getBookChatStatus(PluginCall call, ActivityResult result){
        System.out.println("abcd" + "activity callback");
        if(call == null){
            return;
        }
        Intent data = result.getData();
        System.out.println("abcd" + data.getStringExtra("numberOperation"));
//        JSObject ret = new JSObject();
//        ret.put("value", data);0
//        call.resolve(ret);

    }
}