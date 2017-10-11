package com.example.jh.lovedemo.textsurface.sample.checks;


import com.example.jh.lovedemo.textsurface.Text;
import com.example.jh.lovedemo.textsurface.TextBuilder;
import com.example.jh.lovedemo.textsurface.TextSurface;
import com.example.jh.lovedemo.textsurface.animations.Alpha;
import com.example.jh.lovedemo.textsurface.animations.AnimationsSet;
import com.example.jh.lovedemo.textsurface.animations.TransSurface;
import com.example.jh.lovedemo.textsurface.contants.Align;
import com.example.jh.lovedemo.textsurface.contants.Pivot;
import com.example.jh.lovedemo.textsurface.contants.TYPE;

/**
 * Created by Eugene Levenetc.
 */
public class SurfaceTransSample {
	public static void play(TextSurface textSurface) {
		Text textA = TextBuilder.create("TextA").setPosition(Align.SURFACE_CENTER).build();
		Text textB = TextBuilder.create("TextB").setPosition(Align.RIGHT_OF | Align.BOTTOM_OF, textA).build();
		Text textC = TextBuilder.create("TextC").setPosition(Align.LEFT_OF | Align.BOTTOM_OF, textB).build();
		Text textD = TextBuilder.create("TextD").setPosition(Align.RIGHT_OF | Align.BOTTOM_OF, textC).build();

		int duration = 500;

		textSurface.play(TYPE.SEQUENTIAL,
				Alpha.show(textA, duration),
				new AnimationsSet(TYPE.PARALLEL, Alpha.show(textB, duration), new TransSurface(duration, textB, Pivot.CENTER)),
				new AnimationsSet(TYPE.PARALLEL, Alpha.show(textC, duration), new TransSurface(duration, textC, Pivot.CENTER)),
				new AnimationsSet(TYPE.PARALLEL, Alpha.show(textD, duration), new TransSurface(duration, textD, Pivot.CENTER)),
				new TransSurface(duration, textC, Pivot.CENTER),
				new TransSurface(duration, textB, Pivot.CENTER),
				new TransSurface(duration, textA, Pivot.CENTER)
		);
	}
}
