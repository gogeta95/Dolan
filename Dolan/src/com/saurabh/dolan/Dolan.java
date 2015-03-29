package com.saurabh.dolan;

import android.content.res.XModuleResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class Dolan implements IXposedHookInitPackageResources,IXposedHookZygoteInit{
	private static String MyApp=null;

	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam)
			throws Throwable {
		XModuleResources modres= XModuleResources.createInstance(MyApp, resparam.res);
		if(resparam.packageName.equals("com.adnroid.settings")){
			modify(resparam,"com.android.settings","superuser",modres.getString(R.string.superuser));
		}
		
	}
	public static void modify(InitPackageResourcesParam resparam,String pkg,String tag,String tagnew){
		try{
			resparam.res.setReplacement(pkg+":string/"+tag, tagnew);
		}
		catch(Exception e){}
	}
	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		MyApp=startupParam.modulePath;
		
	}
}
