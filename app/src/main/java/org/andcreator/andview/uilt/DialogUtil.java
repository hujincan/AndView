package org.andcreator.andview.uilt;


import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import org.andcreator.andview.R;
import org.andcreator.andview.dialog.CalendarDialog;
import org.andcreator.andview.dialog.ClockDialog;
import org.andcreator.andview.dialog.LWheelDialog;
import org.andcreator.andview.dialog.Load2Dialog;
import org.andcreator.andview.dialog.Load3Dialog;
import org.andcreator.andview.dialog.LoadDialog;
import org.andcreator.andview.dialog.ProgressDialog;
import org.andcreator.andview.view.LCalendarView;
import org.andcreator.andview.view.LWheelView;


public class DialogUtil {

	private double dialogWidthProportion = 0.7;
	private double dialogHeightProportion = 0.4;

	public Dialog getClockDialog(Activity context, int hour, int minutes, ClockDialog.ClockDialogListener listener) {
		ClockDialog dialog = new ClockDialog(context);
		dialog.setHours(hour);
		dialog.setMinutes(minutes);
		dialog.setListener(listener);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * 0.6);
		p.width = (int) (d.getWidth() * dialogWidthProportion);
		dialog.onWindowAttributesChanged(p);
		window.setAttributes(p);
		return dialog;
	}

	/**
	 * 获取一个没有限制的日期选择对话框
	 *
	 * @param context
	 * @param month
	 * @param year
	 * @param day
	 * @param lis
	 * @return
	 */
	public Dialog getCalendarDialog(Activity context, int month, int year,
									int day, LCalendarView.SlideType slideType, CalendarDialog.CalendarDialogListener lis) {
		CalendarDialog dialog = new CalendarDialog(context, month, year, day,
				slideType,lis);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * dialogHeightProportion);
		p.width = (int) (d.getWidth() * dialogWidthProportion);
		dialog.onWindowAttributesChanged(p);
		window.setAttributes(p);
		return dialog;
	}
	/**
	 * 获取一个有限制的日期选择对话框
	 * @param context
	 * @param month
	 * @param year
	 * @param day
	 * @param startMonth 起始的月份
	 * @param startYear 起始年份
	 * @param startDay 起始日期
	 * @param lis
	 * @return
	 */
	public Dialog getCalendarDialog(Activity context, int month, int year,
                                    int day, int startMonth, int startYear, int startDay,
                                    LCalendarView.SlideType slideType, CalendarDialog.CalendarDialogListener lis) {
		CalendarDialog dialog = new CalendarDialog(context, month, year, day,
				startMonth, startYear, startDay,slideType, lis);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * dialogHeightProportion);
		p.width = (int) (d.getWidth() * dialogWidthProportion);
		dialog.onWindowAttributesChanged(p);
		window.setAttributes(p);
		return dialog;
	}


	/**
	 * 获取一个加载提示dialog
	 *
	 * @param context
	 * @return
	 */
	public Dialog getLoadDialog(Activity context) {
		LoadDialog dialog = new LoadDialog(context);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * 0.2);
		p.width = (int) (d.getWidth() * 0.2);
		dialog.onWindowAttributesChanged(p);
		p.dimAmount = 0f;// 设置背景不变暗
		window.setAttributes(p);
		return dialog;
	}

	/**
	 * 获取一个加载提示dialog
	 *
	 * @param context
	 * @return
	 */
	public Dialog getLoadDialog2(Activity context) {
		Load2Dialog dialog = new Load2Dialog(context);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * 0.5);
		p.width = (int) (d.getWidth() * 0.5);
		p.height = p.width = Math.min(p.height , p.width);
		dialog.onWindowAttributesChanged(p);
		p.dimAmount = 0f;// 设置背景不变暗
		window.setAttributes(p);
		return dialog;
	}

	/**
	 * 获取一个加载提示dialog
	 *
	 * @param context
	 * @return
	 */
	public Dialog getLoadDialog3(Activity context, int showType) {
		Load3Dialog dialog = new Load3Dialog(context,showType);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * 0.5);
		p.width = (int) (d.getWidth() * 0.5);
		p.height = p.width = Math.min(p.height , p.width);
		dialog.onWindowAttributesChanged(p);
		p.dimAmount = 0f;// 设置背景不变暗
		window.setAttributes(p);
		return dialog;
	}

	/**
	 * 获取一个提交进度dialog
	 *
	 * @param context
	 * @return
	 */
	public Dialog getProgressDialog(Activity context, int allInt, int havingInt) {
		ProgressDialog dialog = new ProgressDialog(context, allInt, havingInt);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * 0.6);
		p.width = (int) (d.getWidth() * 0.6);
		dialog.onWindowAttributesChanged(p);
		p.dimAmount = 0f;// 设置背景不变暗
		window.setAttributes(p);
		return dialog;
	}
	/**
	 * 获取一个时间滚轮选择器
	 * @param context
	 * @param type
	 * @param listener
	 * @return
	 */
	public Dialog getWheelDialog(Activity context, LWheelDialog.LWheelDialogType type, LWheelView.LWheelViewListener listener){
		LWheelDialog dialog = new LWheelDialog(context, type, listener);
		Window window = dialog.getWindow();
		window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
		window.setWindowAnimations(R.style.dialogstyle_vertical); // 添加动画
		dialog.setCancelable(true);
		dialog.show();
		WindowManager m = context.getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
		p.height = (int) (d.getHeight() * 0.5);
		p.width = (int) (d.getWidth());
		dialog.onWindowAttributesChanged(p);
		window.setAttributes(p);
		return dialog;
	}
	
	public DialogUtil(double dialogWidthProportion,
                      double dialogHeightProportion) {
		super();
		this.dialogWidthProportion = dialogWidthProportion;
		this.dialogHeightProportion = dialogHeightProportion;
	}

	public DialogUtil() {
		super();
	}

	public double getDialogWidthProportion() {
		return dialogWidthProportion;
	}

	public void setDialogWidthProportion(double dialogWidthProportion) {
		this.dialogWidthProportion = dialogWidthProportion;
	}

	public double getDialogHeightProportion() {
		return dialogHeightProportion;
	}

	public void setDialogHeightProportion(double dialogHeightProportion) {
		this.dialogHeightProportion = dialogHeightProportion;
	}

	public void setWidthAndHeight(double width, double height) {
		this.dialogHeightProportion = height;
		this.dialogWidthProportion = width;
	}

}
