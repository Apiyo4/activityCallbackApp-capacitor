package com.example.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;

import androidx.activity.result.ActivityResult;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Echo")
public class EchoPlugin extends Plugin {
    private BtnClickedService btnService;
    private Boolean isBound;

    @PluginMethod()
    public void echo(PluginCall call) {
        String value = call.getString("value");
        System.out.println("abcd" + value);
        JSObject ret = new JSObject();
        ret.put("value", value);
        Intent i = new Intent(getActivity(), BtnClickedService.class);
//        Intent intent = new Intent(context, YOUR_SERVICE_NAME.class);
        getActivity().bindService(i, mConnection, Context.BIND_AUTO_CREATE);
//        getActivity().startService(i);
//        getActivity().unbindService(mConnection);
//        context.startForegroundService(intent);
//        getActivity().startService(i);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getActivity().startForegroundService(i);
        }
        Intent intent = new Intent(getActivity(), ImportantActivity.class);
//        if(isBound){
//            System.out.println("abcd" + "isbound");
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            startActivityForResult(call, intent, "getBookChatStatus");
//        }

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
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Service is connected
            System.out.println("abcd" + "serviceconnected!");
            btnService = ((BtnClickedService.CallBinder)service).getService();
            isBound = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            // Do things when Service is disconnected
            System.out.println("abcd" + "service disconnected!");
            btnService = null;
            isBound = false;
        }
    };
}