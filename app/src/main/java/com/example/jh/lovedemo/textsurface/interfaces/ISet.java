package com.example.jh.lovedemo.textsurface.interfaces;

import com.example.jh.lovedemo.textsurface.contants.TYPE;

import java.util.LinkedList;


/**
 * Created by Eugene Levenetc.
 */
public interface ISet extends ISurfaceAnimation {
	TYPE getType();

	LinkedList<ISurfaceAnimation> getAnimations();
}
