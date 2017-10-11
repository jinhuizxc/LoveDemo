package com.example.jh.lovedemo.textsurface.sample.checks;


import com.example.jh.lovedemo.textsurface.Text;
import com.example.jh.lovedemo.textsurface.TextBuilder;
import com.example.jh.lovedemo.textsurface.TextSurface;
import com.example.jh.lovedemo.textsurface.animations.Alpha;
import com.example.jh.lovedemo.textsurface.animations.AnimationsSet;
import com.example.jh.lovedemo.textsurface.animations.Delay;
import com.example.jh.lovedemo.textsurface.animations.ScaleSurface;
import com.example.jh.lovedemo.textsurface.contants.Align;
import com.example.jh.lovedemo.textsurface.contants.Fit;
import com.example.jh.lovedemo.textsurface.contants.TYPE;

/**
 * Created by Eugene Levenetc.
 */
public class SurfaceScaleSample {
	public static void play(TextSurface textSurface) {

		Text textA = TextBuilder.create("How are you?").setPosition(Align.SURFACE_CENTER).build();
		Text textB = TextBuilder.create("Would you mind?").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textA).build();
		Text textC = TextBuilder.create("Yes!").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textB).build();


		textSurface.play(TYPE.SEQUENTIAL,
				Alpha.show(textA, 500),
				new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.PARALLEL, Alpha.show(textB, 500), Alpha.hide(textA, 500)),
						new ScaleSurface(500, textB, Fit.WIDTH)
				),
				Delay.duration(1000),
				new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.PARALLEL, Alpha.show(textC, 500), Alpha.hide(textB, 500)),
						new ScaleSurface(500, textC, Fit.WIDTH)
				)
		);
	}
}