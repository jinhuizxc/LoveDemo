package com.example.jh.lovedemo.textsurface.animations;


import com.example.jh.lovedemo.textsurface.contants.TYPE;
import com.example.jh.lovedemo.textsurface.interfaces.ISurfaceAnimation;

/**
 * Created by Eugene Levenetc.
 */
public class Sequential extends AnimationsSet {
	public Sequential(ISurfaceAnimation... animations) {
		super(TYPE.SEQUENTIAL, animations);
	}
}
