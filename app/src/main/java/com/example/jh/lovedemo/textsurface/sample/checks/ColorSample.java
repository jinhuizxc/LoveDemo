package com.example.jh.lovedemo.textsurface.sample.checks;

import android.graphics.Color;

import com.example.jh.lovedemo.textsurface.Text;
import com.example.jh.lovedemo.textsurface.TextBuilder;
import com.example.jh.lovedemo.textsurface.TextSurface;
import com.example.jh.lovedemo.textsurface.animations.Alpha;
import com.example.jh.lovedemo.textsurface.animations.ChangeColor;
import com.example.jh.lovedemo.textsurface.contants.Align;
import com.example.jh.lovedemo.textsurface.contants.TYPE;


/**
 * Created by Eugene Levenetc.
 */
public class ColorSample {
	public static void play(TextSurface textSurface) {

		Text textA = TextBuilder
				.create("Now why you loer en kyk gelyk?")
				.setPosition(Align.SURFACE_CENTER)
				.setSize(100)
				.setAlpha(0)
				.build();

		textSurface.play(TYPE.SEQUENTIAL,
				Alpha.show(textA, 1000),
				ChangeColor.to(textA, 1000, Color.RED),
				ChangeColor.fromTo(textA, 1000, Color.BLUE, Color.CYAN),
				Alpha.hide(textA, 1000)
		);
	}
}
