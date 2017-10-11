package com.example.jh.lovedemo.textsurface.sample.checks;


import com.example.jh.lovedemo.textsurface.Text;
import com.example.jh.lovedemo.textsurface.TextBuilder;
import com.example.jh.lovedemo.textsurface.TextSurface;
import com.example.jh.lovedemo.textsurface.animations.AnimationsSet;
import com.example.jh.lovedemo.textsurface.animations.Rotate3D;
import com.example.jh.lovedemo.textsurface.contants.Align;
import com.example.jh.lovedemo.textsurface.contants.Axis;
import com.example.jh.lovedemo.textsurface.contants.Direction;
import com.example.jh.lovedemo.textsurface.contants.Pivot;
import com.example.jh.lovedemo.textsurface.contants.TYPE;

/**
 * Created by Eugene Levenetc.
 */
public class Rotation3DSample {
	public static void play(TextSurface textSurface) {
		Text textA = TextBuilder.create("How are you?").setPosition(Align.SURFACE_CENTER).build();
		Text textB = TextBuilder.create("I'm fine! And you?").setPosition(Align.SURFACE_CENTER, textA).build();
		Text textC = TextBuilder.create("Haaay!").setPosition(Align.SURFACE_CENTER, textB).build();
		int duration = 2750;

		textSurface.play(TYPE.SEQUENTIAL,
				new AnimationsSet(TYPE.SEQUENTIAL,
						Rotate3D.showFromCenter(textA, duration, Direction.CLOCK, Axis.X),
						Rotate3D.hideFromCenter(textA, duration, Direction.CLOCK, Axis.Y)
				),
				new AnimationsSet(TYPE.SEQUENTIAL,
						Rotate3D.showFromSide(textB, duration, Pivot.LEFT),
						Rotate3D.hideFromSide(textB, duration, Pivot.RIGHT)
				),
				new AnimationsSet(TYPE.SEQUENTIAL,
						Rotate3D.showFromSide(textC, duration, Pivot.TOP),
						Rotate3D.hideFromSide(textC, duration, Pivot.BOTTOM)
				)
		);
	}
}
