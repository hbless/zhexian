package com.example.zhexian;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class TrendView extends View{
	private List<Integer>highestDatas;//最高温度对应的数据
	private List<Integer>lowestDatas;//最低温度对应的数据
	private int xSpace;//x轴两点间的距离
	private int ySpace;//y轴两点间的距离
	private int centerHeight;
	private int x[];//保存各个坐标点的x坐标
	private int radius=5;//每个点的半径
	//定义一些画笔，用于绘制坐标点，文本，温度先，x坐标线
	private Paint pointPaint,textPaint,lowPaint,hightPaint,xPaint;
	private float textHeight;//文字高度
	private int arrawSpace=8;//x轴和y轴上箭头的间距
	private int max,min,mindleData;//保存所有数据的最大值，最小值，中间值
	private String[] weeks=new String[]{"周一","周二","周三","周四","周五","周六","周日"};
	private int width,height;
	private List<Integer>datas=new ArrayList<Integer>();
	public TrendView(Context context,List<Integer>lowestDatas,List<Integer>highestDatas){
		super(context);
		x=new int[highestDatas.size()];//保留多少个横坐标
		this.lowestDatas=lowestDatas;
		this.highestDatas=highestDatas;
		datas.addAll(highestDatas);
		datas.addAll(lowestDatas);
		getMaxAndMin(datas);
		init();//初始化各种画笔
		
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
	}

	private void getMaxAndMin(List<Integer> datas2) {
		// TODO Auto-generated method stub
		
	}

	public TrendView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		width=this.getWidth();//获取控件的宽度
		height=this.getHeight();//获取控件的高度
		xSpace=(width-40)/highestDatas.size();//x轴上面两点的距离，左右各保留20像数
		for(int i=0;i<x.length;i++){
			x[i]=40+i*xSpace;
		}
		mindleData=(max+min)/2;//获取中间值
		ySpace=(height-200)/(max-min);//最大值和最小值之间一共有多少个单位，上下哥保留100像数
		centerHeight=(height-200)/2+100;//获取控件y轴的中间线
		drawXY(canvas);//画xy轴以及一些信息
		drawLine(highestDatas,canvas,hightPaint,true);
		drawLine(lowestDatas,canvas,lowPaint,false);
		
		
	}

	private void drawLine(List<Integer>datas, Canvas canvas,
			Paint linePaint, boolean isTexUp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < datas.size(); i++) {
			int data=datas.get(i);
			float point=(-(data-mindleData))*ySpace;//该点相对于中线的纵坐标
			canvas.drawCircle(x[i], centerHeight, radius, pointPaint);
		}
	}
	private void drawXY(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
}
