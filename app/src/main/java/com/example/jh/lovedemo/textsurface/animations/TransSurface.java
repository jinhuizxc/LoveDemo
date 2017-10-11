package com.example.jh.lovedemo.textsurface.animations;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.Log;

import com.example.jh.lovedemo.textsurface.Debug;
import com.example.jh.lovedemo.textsurface.SurfaceCamera;
import com.example.jh.lovedemo.textsurface.Text;
import com.example.jh.lovedemo.textsurface.TextSurface;
import com.example.jh.lovedemo.textsurface.contants.Pivot;
import com.example.jh.lovedemo.textsurface.interfaces.ICameraAnimation;
import com.example.jh.lovedemo.textsurface.interfaces.IEndListener;
import com.example.jh.lovedemo.textsurface.utils.Utils;


/**
 * Created by Eugene Levenetc.
 */
public class TransSurface implements ICameraAnimation, ValueAnimator.AnimatorUpdateListener {

	public float dx;
	public float dy;
	private int duration;
	private Text textPivot;
	private int pivot;
	private TextSurface textSurface;
	private SurfaceCamera camera;
	private ObjectAnimator animator;

	public static TransSurface toCenter(Text textPivot, int duration){
		return new TransSurface(duration, textPivot, Pivot.CENTER);
	}

	public TransSurface(int duration, Text textPivot, int pivot) {
		this.duration = duration;
		this.textPivot = textPivot;
		this.pivot = pivot;
	}

	public TransSurface(int duration, Text textPivot) {
		this.duration = duration;
		this.textPivot = textPivot;
	}

	public TransSurface(int duration, float dx, float dy) {
		this.duration = duration;
		this.dx = dx;
		this.dy = dy;
	}

	@Override
    public void onStart() {

	}

	@Override
    public void start(final IEndListener listener) {

		float fromX = camera.getTransX();
		float fromY = camera.getTransY();

		float toX;
		float toY;

		if (textPivot == null) {
			toX = camera.getTransX() + dx;
			toY = camera.getTransY() + dy;
		} else {
			toX = textPivot.getPosition().getRelativeX(pivot, textPivot, true) * camera.getScale() * -1;
			toY = textPivot.getPosition().getRelativeY(pivot, textPivot, true) * camera.getScale() * -1;
		}

		debugTranslation(fromX, fromY, toX, toY);

		PropertyValuesHolder dxHolder = PropertyValuesHolder.ofFloat("transX", fromX, toX);
		PropertyValuesHolder dyHolder = PropertyValuesHolder.ofFloat("transY", fromY, toY);

		animator = ObjectAnimator.ofPropertyValuesHolder(camera, dxHolder, dyHolder);
		animator.setInterpolator(new FastOutSlowInInterpolator());
		Utils.addEndListener(this, animator, listener);
		animator.setDuration(duration);
		animator.addUpdateListener(this);
		animator.start();
	}

	private void debugTranslation(float fromX, float fromY, float toX, float toY) {
		if (Debug.ENABLED && fromX == toX && fromY == toY)
			Log.e(getClass().getSimpleName(), "No translation to " + textPivot + " from:" + fromX + ":" + fromY + " to:" + toX + ":" + toY);
	}

	@Override
    public void setTextSurface(TextSurface textSurface) {
		this.textSurface = textSurface;
	}

	@Override
    public long getDuration() {
		return duration;
	}

	@Override
    public void cancel() {
		if (animator != null && animator.isRunning()) {
			animator.cancel();
			animator = null;
		}
	}

	@Override
    public void onAnimationUpdate(ValueAnimator animation) {
		textSurface.invalidate();
	}

	@Override
    public void setCamera(SurfaceCamera camera) {
		this.camera = camera;
	}

	@Override
    public String toString() {
		return "TransSurface{" +
				"textPivot=" + ((textPivot == null) ? "null" : textPivot.toString()) +
				'}';
	}
}
