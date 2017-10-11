package com.example.jh.lovedemo.textsurface.interfaces;


import com.example.jh.lovedemo.textsurface.Text;

/**
 * Created by Eugene Levenetc.
 */
public interface ITextSurfaceAnimation extends ISurfaceAnimation {

	void setInitValues(Text text);

	Text getText();

}