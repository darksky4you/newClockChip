package com.nextos.cccccccc.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nextos.cccccccc.R;

public class xClockBG extends AdvancedCardView{
    int isCustomRadius , isBackgroundColorStyle , BgColor , BgColorEnd ,  isBackgroundStyle , xStrokeType, xStrokeWidth , xStrokeColor , xStrokeDash ,xStrokeGap , xStrockColorType , xStrokeColorEnd ,xStrokeGradientAngle;
    float xGradientAngle , radius , radiusTopLeft , radiusTopRight , radiusBottomRight , radiusBottomLeft;

    ContentResolver contentResolver = getContext().getContentResolver();

    public xClockBG(@NonNull Context context) {
        super(context);
        xRadius();
        xChipBackground();
        xStroke();

    }

    public xClockBG(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        xRadius();
        xChipBackground();
        xStroke();

    }

    public xClockBG(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        xChipBackground();
        xRadius();
        xStroke();

    }

    private void xRadius(){
        isCustomRadius = Settings.System.getInt(contentResolver, "chip_radius_style", 0);
        if (isCustomRadius == 1) {
            radiusTopLeft = Settings.System.getInt(contentResolver, "chip_main_radius", 10);
            radiusTopRight = Settings.System.getInt(contentResolver, "chip_topRight_radius", 10);
            radiusBottomRight = Settings.System.getInt(contentResolver, "chip_bottomRight_radius", 10);
            radiusBottomLeft = Settings.System.getInt(contentResolver, "chip_bottomLeft_radius", 10);
            setCorners(radiusTopLeft, radiusTopRight , radiusBottomRight , radiusBottomLeft);

        } else {
            radius = Settings.System.getInt(contentResolver, "chip_main_radius", 10);
            setCornerRadius_(radius);
        }


    }
    private void xChipBackground(){
        isBackgroundStyle = Settings.System.getInt(contentResolver, "chip_background_style", 0);
        if (isBackgroundStyle == 1){
            setBackground_Type(BackgroundType.Stroke);
        } else if (isBackgroundStyle == 2) {
            setBackground_Type(BackgroundType.Fill_Stroke);
            xChipBackgroundColor();
        }
        else {
            setBackground_Type(BackgroundType.Fill);
            xChipBackgroundColor();
        }
    }
    private void xChipBackgroundColor(){
        xGradientAngle = Settings.System.getInt(contentResolver , "chip_gradient_angle" , 0);
        isBackgroundColorStyle = Settings.System.getInt(contentResolver, "chip_background_color_style", 0);
        if (isBackgroundColorStyle == 1){
            setBackground_ColorType(ColorType.Solid);
            BgColor = Settings.System.getInt(contentResolver, "chip_main_color", 0);
            setBackground_Color(BgColor);
        }
        else if(isBackgroundColorStyle==2)  {
            setBackground_ColorType(ColorType.Gradient_Linear);
            BgColor = Settings.System.getInt(contentResolver, "chip_main_color", 0);
            BgColorEnd = Settings.System.getInt(contentResolver, "chip_end_color", 0);
            int Gradient [] = {BgColor ,BgColorEnd };
            setBackground_Gradient_Colors(Gradient);
            setBackground_Gradient_Angle(xGradientAngle);

        }
        else if(isBackgroundColorStyle==3)  {
            setBackground_ColorType(ColorType.Gradient_Radial);
            BgColor = Settings.System.getInt(contentResolver, "chip_main_color", 0);
            BgColorEnd = Settings.System.getInt(contentResolver, "chip_end_color", 0);
            int Gradient [] = {BgColor ,BgColorEnd };
            setBackground_Gradient_Colors(Gradient);
            setBackground_Gradient_Angle(xGradientAngle);

        }
        else if(isBackgroundColorStyle==4)  {
            setBackground_ColorType(ColorType.Gradient_Sweep);
            BgColor = Settings.System.getInt(contentResolver, "chip_main_color", 0);
            BgColorEnd = Settings.System.getInt(contentResolver, "chip_end_color", 0);
            int Gradient [] = {BgColor ,BgColorEnd };
            setBackground_Gradient_Colors(Gradient);
            setBackground_Gradient_Angle(xGradientAngle);

        }
        else {
            setBackground_ColorType(ColorType.Solid);
            BgColor = R.color.monet_color;
            setBackground_Color(BgColor);
        }




    }

    private void xStroke(){
        xStrokeType = Settings.System.getInt(contentResolver , "chip_stroke_type" , 0);
        xStrokeWidth = Settings.System.getInt(contentResolver , "chip_stroke_width" , 1);

        if (xStrokeType == 1) {
            setStroke_Type(StrokeType.Dash);
            xStrokeDash = Settings.System.getInt(contentResolver , "chip_stroke_dash" , 1);
            xStrokeGap = Settings.System.getInt(contentResolver , "chip_stroke_gap" , 1);
            setStroke_DashSize(xStrokeDash);
            setStroke_GapSize(xStrokeGap);

        }
        else {
            setStroke_Type(StrokeType.Solid);
        }
        xStrokeColor();
        setStroke_Width(xStrokeWidth);




    }
    private void xStrokeColor(){
        xStrockColorType = Settings.System.getInt(contentResolver , "chip_stroke_color_type" , 0);
        if (xStrockColorType == 1){
            setStroke_ColorType(ColorType.Gradient_Linear);
            xStrokeColor = Settings.System.getInt(contentResolver, "chip_stroke_main_color", 0);
            xStrokeColorEnd = Settings.System.getInt(contentResolver, "chip_stroke_end_color", 0);
            xStrokeGradientAngle = Settings.System.getInt(contentResolver , "chip_stroke_gradient_angle" , 0);
            int StrokeGradient [] = {xStrokeColor ,xStrokeColorEnd };
            setStroke_Gradient_Colors(StrokeGradient);
            setStroke_Gradient_Angle(xStrokeGradientAngle);

        }
        else {
            setStroke_ColorType(ColorType.Solid);
            xStrokeColor = Settings.System.getInt(contentResolver, "chip_stroke_main_color", 0);
            setStroke_Color(xStrokeColor);

        }
    }

}
