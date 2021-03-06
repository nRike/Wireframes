package com.senselabs.wireframe.adapter;



import com.senselabs.wireframe.R;
import com.senselabs.wireframe.R.drawable;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// Create a new ImageView for each item referenced by the adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		CheckableLayout checkableLayout = null;
		// if it's not recycled, initialize some attributes
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
			checkableLayout = new CheckableLayout(mContext);
			checkableLayout.setLayoutParams(new GridView.LayoutParams(
					GridView.LayoutParams.WRAP_CONTENT,
					GridView.LayoutParams.WRAP_CONTENT));
			checkableLayout.addView(imageView);
		} else {
            checkableLayout = (CheckableLayout) convertView;
            imageView = (ImageView) checkableLayout.getChildAt(0);
//			imageView = (ImageView) convertView;
		}
	
		imageView.setImageResource(mThumbIds[position]);
		return checkableLayout;
	}

	// references to our images
	private Integer[] mThumbIds = { R.drawable.sample_2, R.drawable.sample_3,
			R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6,
			R.drawable.sample_7, R.drawable.sample_0, R.drawable.sample_1,
			R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4,
			R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
			R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
			R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
			R.drawable.sample_6, R.drawable.sample_7, };

	public class CheckableLayout extends FrameLayout implements Checkable {
		private boolean mChecked;

		public CheckableLayout(Context context) {
			super(context);
		}

		public void setChecked(boolean checked) {
			mChecked = checked;
			setBackgroundDrawable(checked ? getResources().getDrawable(
					R.drawable.blue) : null);
		}

		public boolean isChecked() {
			return mChecked;
		}

		public void toggle() {
			setChecked(!mChecked);
		}

	}

}