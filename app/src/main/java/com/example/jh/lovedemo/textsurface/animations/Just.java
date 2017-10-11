package com.example.jh.lovedemo.textsurface.animations;


import com.example.jh.lovedemo.textsurface.Text;
import com.example.jh.lovedemo.textsurface.contants.TYPE;
import com.example.jh.lovedemo.textsurface.interfaces.IEndListener;

/**
 * Created by Eugene Levenetc.
 */
public class Just extends AbstractSurfaceAnimation {

	public static AnimationsSet show(Text... texts) {
		Just[] justs = new Just[texts.length];
		for (int i = 0; i < texts.length; i++) justs[i] = Just.show(texts[i]);
		return new AnimationsSet(TYPE.PARALLEL, justs);
	}

	public static Just show(Text text) {
		return new Just(text);
	}

	private Just(Text text) {
		super(text, 0);
	}

	@Override
    public void start(IEndListener listener) {
		textSurface.invalidate();
		if (listener != null) listener.onAnimationEnd(this);
	}
}
