package com.gdev.tes.invert.color;
import android.content.*;
import android.preference.*;
/*18/09/2017 created by Hendriyawan @GDEV
/*Silahkan kembangkan sendiri :) */

public class ThemeUtils
{
	private static SharedPreferences pref;
	private static SharedPreferences.Editor editor;
	//create Theme
	public static void createTheme(Context context)
	{
		pref = PreferenceManager.getDefaultSharedPreferences(context);
		int theme = pref.getInt("theme_app", 0);
		switch(theme)
		{
			case 0:
			context.setTheme(R.style.ThemeLight);
			break;
			
			case 1:
			context.setTheme(R.style.ThemeDark);
			break;
		}
	}
	//check if theme is Light
	public static boolean isThemeLight(Context context)
	{
		pref = PreferenceManager.getDefaultSharedPreferences(context);
		return pref.getBoolean("is_theme_light", true);
	 }
	//set Theme
	public static void setTheme(Context context, boolean isLight, int theme)
	{
		pref = PreferenceManager.getDefaultSharedPreferences(context);
		editor = pref.edit();
		editor.putBoolean("is_theme_light", isLight);
		editor.putInt("theme_app", theme);
		editor.commit();
	}
}