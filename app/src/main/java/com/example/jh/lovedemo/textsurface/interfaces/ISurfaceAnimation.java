package com.example.jh.lovedemo.textsurface.interfaces;


import com.example.jh.lovedemo.textsurface.TextSurface;

/**
 * Created by Eugene Levenetc.
 */
public interface ISurfaceAnimation {

	void onStart();

	void start(IEndListener listener);

	void setTextSurface(TextSurface textSurface);

	long getDuration();

	void cancel();

}
