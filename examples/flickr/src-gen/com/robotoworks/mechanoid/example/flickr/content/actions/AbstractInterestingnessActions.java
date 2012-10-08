/*
 * Generated by Robotoworks Mechanoid
 */
package com.robotoworks.mechanoid.example.flickr.content.actions;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.net.Uri;
import com.robotoworks.mechanoid.sqlite.ContentProviderActions;
import com.robotoworks.mechanoid.sqlite.MechanoidContentProvider;
import com.robotoworks.mechanoid.sqlite.SelectionQueryBuilder;
import static com.robotoworks.mechanoid.sqlite.SelectionQueryBuilder.Op.*;

import com.robotoworks.mechanoid.example.flickr.content.AbstractFlickrOpenHelper.Tables;
import com.robotoworks.mechanoid.example.flickr.content.FlickrContract.Interestingness;
			
public abstract class AbstractInterestingnessActions extends ContentProviderActions {
	@Override
	public int delete(MechanoidContentProvider provider, Uri uri, String selection, String[] selectionArgs){
		
		
		final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();
		final Context context = provider.getContext();

		int affected = db.delete(Tables.INTERESTINGNESS, selection, selectionArgs);
		context.getContentResolver().notifyChange(uri, null);
		return affected;
	}
	
	@Override
	public Uri insert(MechanoidContentProvider provider, Uri uri, ContentValues values){
		final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();
		final Context context = provider.getContext();

		long id = db.insertOrThrow(Tables.INTERESTINGNESS, null, values);
		context.getContentResolver().notifyChange(uri, null);
		return Interestingness.buildGetByIdUri(String.valueOf(id));
	}
	
	@Override
	public int update(MechanoidContentProvider provider, Uri uri, ContentValues values, String selection, String[] selectionArgs){
		final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();
		final Context context = provider.getContext();
		
		int affected = db.update(Tables.INTERESTINGNESS, values, selection, selectionArgs);
		context.getContentResolver().notifyChange(uri, null);
		return affected;
	}

	@Override
	public Cursor query(MechanoidContentProvider provider, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){
		final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();
		
		return db.query(Tables.INTERESTINGNESS, projection, selection, selectionArgs, null, null, sortOrder);
	}
}