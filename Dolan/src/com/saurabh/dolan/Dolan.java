package com.saurabh.dolan;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class Dolan implements IXposedHookInitPackageResources{

	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam)
			throws Throwable {
		if(resparam.packageName.equals("com.adnroid.settings")){
			
		}
		
	}
	public static void modify(InitPackageResourcesParam resparam,String pkg,String tag,String tagnew){
		try{
			resparam.res.setReplacement(pkg,"string",tag, tagnew);
		}
		catch(Exception e){}
	}
}