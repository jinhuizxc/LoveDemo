package com.example.jh.lovedemo.textsurface.animations;


import com.example.jh.lovedemo.textsurface.contants.TYPE;
import com.example.jh.lovedemo.textsurface.interfaces.ISurfaceAnimation;

/**
 * Created by Eugene Levenetc.
 */
public class Parallel extends AnimationsSet {
	public Parallel(ISurfaceAnimation... animations) {
		super(TYPE.PARALLEL, animations);
	}
}
