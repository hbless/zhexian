package com.example.zhexian;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class TrendView extends View{
	private List<Integer>highestDatas;//����¶ȶ�Ӧ������
	private List<Integer>lowestDatas;//����¶ȶ�Ӧ������
	private int xSpace;//x�������ľ���
	private int ySpace;//y�������ľ���
	private int centerHeight;
	private int x[];//�������������x����
	private int radius=5;//ÿ����İ뾶
	//����һЩ���ʣ����ڻ�������㣬�ı����¶��ȣ�x������
	private Paint pointPaint,textPaint,lowPaint,hightPaint,xPaint;
	private float textHeight;//���ָ߶�
	private int arrawSpace=8;//x���y���ϼ�ͷ�ļ��
	private int max,min,mindleData;//�����������ݵ����ֵ����Сֵ���м�ֵ
	private String[] weeks=new String[]{"��һ","�ܶ�","����","����","����","����","����"};
	private int width,height;
	private List<Integer>datas=new ArrayList<Integer>();
	public TrendView(Context context,List<Integer>lowestDatas,List<Integer>highestDatas){
		super(context);
		x=new int[highestDatas.size()];//�������ٸ�������
		this.lowestDatas=lowestDatas;
		this.highestDatas=highestDatas;
		datas.addAll(highestDatas);
		datas.addAll(lowestDatas);
		getMaxAndMin(datas);
		init();//��ʼ�����ֻ���
		
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
		width=this.getWidth();//��ȡ�ؼ��Ŀ��
		height=this.getHeight();//��ȡ�ؼ��ĸ߶�
		xSpace=(width-40)/highestDatas.size();//x����������ľ��룬���Ҹ�����20����
		for(int i=0;i<x.length;i++){
			x[i]=40+i*xSpace;
		}
		mindleData=(max+min)/2;//��ȡ�м�ֵ
		ySpace=(height-200)/(max-min);//���ֵ����Сֵ֮��һ���ж��ٸ���λ�����¸籣��100����
		centerHeight=(height-200)/2+100;//��ȡ�ؼ�y����м���
		drawXY(canvas);//��xy���Լ�һЩ��Ϣ
		drawLine(highestDatas,canvas,hightPaint,true);
		drawLine(lowestDatas,canvas,lowPaint,false);
		
		
	}

	private void drawLine(List<Integer>datas, Canvas canvas,
			Paint linePaint, boolean isTexUp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < datas.size(); i++) {
			int data=datas.get(i);
			float point=(-(data-mindleData))*ySpace;//�õ���������ߵ�������
			canvas.drawCircle(x[i], centerHeight, radius, pointPaint);
		}
	}
	private void drawXY(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
}
