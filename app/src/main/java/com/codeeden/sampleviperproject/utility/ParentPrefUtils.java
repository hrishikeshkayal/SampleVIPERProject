package com.codeeden.sampleviperproject.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class ParentPrefUtils {
	Context context;
	SharedPreferences prefs;

	public ParentPrefUtils(Context mcontext) {
		this.context = mcontext;
		this.prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
	}

	public String getString(String key, String def) {

		String s = prefs.getString(key, def);
		return s;
	}

	public int getInt(String key, int def) {

		int i = Integer.parseInt(prefs.getString(key, Integer.toString(def)));
		return i;
	}

	public float getFloat(String key, float def) {

		float f = Float.parseFloat(prefs.getString(key, Float.toString(def)));
		return f;
	}

	public long getLong(String key, long def) {

		long l = Long.parseLong(prefs.getString(key, Long.toString(def)));
		return l;
	}

	public void setString(String key, String val) {

		Editor e = prefs.edit();
		e.putString(key, val);
		e.commit();
	}

	public void setBoolean(String key, boolean val) {

		Editor e = prefs.edit();
		e.putBoolean(key, val);
		e.commit();
	}

	public void setInt(String key, int val) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor e = prefs.edit();
		e.putString(key, Integer.toString(val));
		e.commit();
	}

	public void setLong(String key, long val) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor e = prefs.edit();
		e.putString(key, Long.toString(val));
		e.commit();
	}

	public boolean getBoolean(String key, boolean def) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		boolean b = prefs.getBoolean(key, def);
		return b;
	}

	public void setDouble(String key, double val) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor e = prefs.edit();
		e.putString(key, Double.toString(val));
		e.commit();
	}

	public double getDouble(String key, double def) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		double b = Double
				.parseDouble(prefs.getString(key, Double.toString(def)));
		return b;
	}

	public SharedPreferences getPrefs() {
		return prefs;
	}
}
